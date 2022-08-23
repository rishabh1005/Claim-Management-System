package com.cognizant.claimsmicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;

/*Proxy for policy microservice 
 *3 end points
*/
@FeignClient(name = "policy-microservice", url = "http://localhost:5000/policy")
//@FeignClient(name = "POLICY-MICROSERVICE")
public interface PolicyClient {
	@GetMapping(value = "getChainOfProviders/{policyId}")
	public List<ProviderPolicy> getChainOfProviders(@PathVariable("policyId") int policyId,
			@RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping(value = "getEligibleBenefits/{policyId}/{memberId}")
	public List<Benefits> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId,
			@RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping("/getClaimAmount/{policyId}/{memberId}/{benefitId}")
	public double getClaimAmount(@PathVariable int policyId, @PathVariable int memberId, @PathVariable int benefitId,
			@RequestHeader(name = "Authorization", required = true) String token);

}
