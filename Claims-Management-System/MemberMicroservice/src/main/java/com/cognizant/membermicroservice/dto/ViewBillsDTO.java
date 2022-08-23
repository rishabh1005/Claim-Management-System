package com.cognizant.membermicroservice.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ViewBillsDTO {

	private Date paidDate;
	private double premium;
	private boolean latePayment;
	private double latePaymentCharges;
	private Date dueDate;
}
