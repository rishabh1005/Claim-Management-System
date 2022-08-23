package com.cognizant.membermicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_premium")
@Getter
@Setter
@NoArgsConstructor
@Component
public class MemberPremium {

	@Id
	private int memberId;
	private int policyId;
	private Date paidDate;
	private Date dueDate;
	private double premium;
	private boolean latePayment;
	private double latePaymentCharges;
}
