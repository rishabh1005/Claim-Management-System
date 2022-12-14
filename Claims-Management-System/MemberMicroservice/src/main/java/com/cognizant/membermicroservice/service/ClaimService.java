package com.cognizant.membermicroservice.service;

import com.cognizant.membermicroservice.dto.ViewBillsDTO;

/*
 * This interface is to declare the viewBills method to get the bill details.
 */

public interface ClaimService {

	/*
	 * @param memberId
	 * 
	 * @param policyId
	 * 
	 * @return ViewBillsDTO
	 */

	public ViewBillsDTO viewBills(int memberId, int policyId);

}