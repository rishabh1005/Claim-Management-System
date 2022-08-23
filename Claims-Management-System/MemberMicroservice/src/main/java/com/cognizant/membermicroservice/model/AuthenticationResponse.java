package com.cognizant.membermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a model class which will be used for generating response for the authentication request. 
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
	private String jwtToken;
	private Boolean valid;

}
