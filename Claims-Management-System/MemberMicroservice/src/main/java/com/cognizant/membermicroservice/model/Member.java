package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member {
	@Id

	private int memberId;
	private String memberName;
	private String phoneNumber;
	private int salary;
	private String gender;
}
