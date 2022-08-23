package com.cognizant.policymicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.MemberPolicy;

@Service
public interface IMemberPolicyService {
	List<MemberPolicy> findAllByPolicyIdAndMemberId(int policyId, int memberId);
	MemberPolicy findCapAmount(int policyId, int memberId, int benefitId);
}
