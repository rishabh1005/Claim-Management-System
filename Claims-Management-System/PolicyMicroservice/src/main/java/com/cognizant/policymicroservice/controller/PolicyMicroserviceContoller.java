package com.cognizant.policymicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.policymicroservice.client.AuthClient;
import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.service.IBenefitService;
import com.cognizant.policymicroservice.service.IMemberPolicyService;
import com.cognizant.policymicroservice.service.IProviderPolicyService;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * This class contains operations for getting the claim providers,eligible
 * benefits,eligible claim amount
 * 
 * @author Shailesh Goyal
 */
@RestController
@Api(value = "policy Microservice Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyMicroserviceContoller {

	@Autowired
	IProviderPolicyService providerPolicyService;

	@Autowired
	IMemberPolicyService memberPolicyService;

	@Autowired
	IBenefitService benefitService;

	@Autowired
	AuthClient authClient;

	/*
	 * This method invokes authorizationMicroservice to validate the token
	 * 
	 * if token is valid then returns the list of providers which accepts the claim
	 * for particular policy if token is invalid then returns responseEntity of type
	 * String(message) and status as forbidden
	 */
	@ApiOperation(value = "List of providers which accepts the claim for particular policy")
	@GetMapping(value = "getChainOfProviders/{policyId}", produces = "application/json")
	public ResponseEntity<?> getChainOfProviders(@PathVariable("policyId") int policyId,
			@RequestHeader(name = "Authorization", required = true) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);

		}
		List<ProviderPolicy> providers = providerPolicyService.findAllByPolicyIdOrderByLocation(policyId);
		return new ResponseEntity<>(providers, HttpStatus.OK);
	}

	/*
	 * This method invokes authorizationMicroservice to validate the token if token
	 * is valid then returns the list of providers which are under a particular
	 * policy if token is invalid then returns responseEntity of tyep
	 * String(message) and status as forbidden
	 */
	@ApiOperation(value = "List of benefits which can be aviled under a particular policy")
	@GetMapping(value = "getEligibleBenefits/{policyId}/{memberId}", produces = "application/json")
	public ResponseEntity<?> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId,
			@RequestHeader(name = "Authorization", required = true) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {
				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}
		List<MemberPolicy> providers = memberPolicyService.findAllByPolicyIdAndMemberId(policyId, memberId);

		List<Benefits> benefitDetails = new ArrayList<Benefits>();
		for (MemberPolicy memberPolicy : providers) {
			int benefitId = memberPolicy.getBenefitId();
			benefitDetails.add(benefitService.findByBenefitId(benefitId));

		}
		return new ResponseEntity<>(benefitDetails, HttpStatus.OK);

	}

	/*
	 * This method invokes authorizationMicroservice to validate the token
	 * 
	 * if token is valid then returns the amount that a particular member can claim
	 * 
	 * if token is invalid then returns responseEntity of type String(message) and
	 * status as forbidden
	 */
	@ApiOperation(value = "Eligible claim amount that a member can claim")
	@GetMapping(value = "/getClaimAmount/{policyId}/{memberId}/{benefitId}", produces = "application/json")
	public ResponseEntity<?> getEligibleClaimAmount(@PathVariable int policyId, @PathVariable int memberId,
			@PathVariable int benefitId, @RequestHeader(name = "Authorization", required = true) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {
				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}
		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}
		MemberPolicy mempolicy = memberPolicyService.findCapAmount(policyId, memberId, benefitId);

		return new ResponseEntity<Double>(mempolicy.getCapAmountBenefits(), HttpStatus.OK);
	}
}