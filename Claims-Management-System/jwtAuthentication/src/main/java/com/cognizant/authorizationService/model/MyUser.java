package com.cognizant.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myuser")
/*
 * This is the model class for username, password, token
 */
public class MyUser {

	@Id
	@Column(name = "memberid")
	private String memberid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	private String token;

	public MyUser(String memberid, String username, String password) {
		super();
		this.memberid = memberid;
		this.username = username;
		this.password = password;
	}
}
