package com.cognizant.policymicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.repository.ProviderPolicyRepo;

@Service
public class ProviderPolicyService  implements IProviderPolicyService{

	@Autowired
	ProviderPolicyRepo providerPolicyRepo;
	
	@Override
	public List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int policyId){
		return providerPolicyRepo.findAllByPolicyIdOrderByLocation(policyId);
	}
}
