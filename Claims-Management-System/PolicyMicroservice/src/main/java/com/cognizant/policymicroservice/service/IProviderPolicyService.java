package com.cognizant.policymicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.ProviderPolicy;

@Service
public interface IProviderPolicyService {
	List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int policyId);

}
