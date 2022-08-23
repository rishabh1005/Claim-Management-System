package com.cognizant.policymicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.repository.BenefitRepo;

@Service
public class BenefitService implements IBenefitService{
	
	@Autowired
	BenefitRepo benefitRepo;
	
	@Override
	public Benefits findByBenefitId(int benefitId) {
		return benefitRepo.findByBenefitId(benefitId);
	}
	

}
