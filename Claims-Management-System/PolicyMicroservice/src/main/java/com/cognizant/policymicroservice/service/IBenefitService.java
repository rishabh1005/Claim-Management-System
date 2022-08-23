package com.cognizant.policymicroservice.service;

import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.Benefits;

@Service
public interface IBenefitService {
	
	Benefits findByBenefitId(int benefitId);

}
