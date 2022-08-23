package com.cognizant.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * This is the model class for AuthenticationRequest
 */
public class AuthenticationRequest {

	private String username;
	private String password;

}
