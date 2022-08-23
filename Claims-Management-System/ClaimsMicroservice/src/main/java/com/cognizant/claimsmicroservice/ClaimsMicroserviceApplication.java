package com.cognizant.claimsmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ClaimsMicroserviceApplication implements CommandLineRunner {

	private ClaimRepository claimRepository;

	public ClaimsMicroserviceApplication(ClaimRepository claimRepository) {
		super();
		this.claimRepository = claimRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClaimsMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	claimRepository.save(new Claim(1, "Pending Action","claim has been submitted! Please check after few days for confirmation", 1, 2, 201, 1, 100000.0, 80000.0));
	claimRepository.save(new Claim(2, "Pending Action","claim has been submitted! Please check after few days for confirmation", 1, 1, 201, 2, 100000.0, 60000.0));
	}

}
