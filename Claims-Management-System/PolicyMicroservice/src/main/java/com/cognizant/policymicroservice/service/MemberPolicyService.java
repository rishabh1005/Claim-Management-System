package com.cognizant.policymicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;

@Service
public class MemberPolicyService implements IMemberPolicyService{
	
	@Autowired
	MemberPolicyRepo memberPolicyRepo;
	
	@Override
	public List<MemberPolicy> findAllByPolicyIdAndMemberId(int policyId, int memberId){
		return memberPolicyRepo.findAllByPolicyIdAndMemberId(policyId,memberId);
	}
	
	@Override
	public MemberPolicy findCapAmount(int policyId, int memberId, int benefitId) {
		return memberPolicyRepo.findCapAmount(policyId,memberId,benefitId);
	}

}
