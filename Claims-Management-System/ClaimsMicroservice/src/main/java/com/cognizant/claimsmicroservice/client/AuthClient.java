package com.cognizant.claimsmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.claimsmicroservice.model.AuthenticationResponse;

/*
 * This class communicates with JwtAuthentication microservice to verify the
 * token. using Feign client With provided URL and name of microservice it
 * interact with that microservice.
 *
 */
@FeignClient(name = "authenticationFeignClient", url = "http://localhost:8089/authorization")
//@FeignClient(name="AUTHENTICATIONFEIGNCLIENT")
public interface AuthClient {

	@GetMapping("/validate")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token);
}