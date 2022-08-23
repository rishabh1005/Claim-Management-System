package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_claim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MemberClaim {

	@Id
	private int claimId;
	private int policyId;
	private int memberId;
	private int providerId;
	private int benefitId;
	private double totalBilledAmount;
	private double totalClaimedAmount;
	private String claimStatus;
	private String claimDescription;
}
