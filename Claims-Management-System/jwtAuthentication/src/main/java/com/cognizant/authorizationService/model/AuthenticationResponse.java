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
 * This is the model class for AuthenticationResponse
 */
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;
}
