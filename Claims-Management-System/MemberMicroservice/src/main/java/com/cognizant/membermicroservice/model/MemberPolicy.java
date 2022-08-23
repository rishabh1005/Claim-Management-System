package com.cognizant.membermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberPolicy {
	private int memberId;
	private String memberName;
	private int policyId;
	private String subscriptionDate;
	private int locationId;
	private String locationName;
	private int providerId;
	private String providerName;
}
