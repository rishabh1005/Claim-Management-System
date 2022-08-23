package com.cognizant.policymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/* 
 * POD 2 -Claims Management System This is Application class for Spring boot
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PolicyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroserviceApplication.class, args);
	}

}
