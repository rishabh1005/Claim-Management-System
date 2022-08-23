package com.cognizant.authorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.cognizant.authorizationService.Repository.UserRepository;
import com.cognizant.authorizationService.model.MyUser;

@SpringBootApplication
@EnableDiscoveryClient
/*
 * POD 2 -Claims Management System This is Application class for Spring boot
 */
public class JwtAuthenticationApplication {
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<MyUser> users = Stream.of(new MyUser("1", "Shailesh", "Shailesh"), new MyUser("2", "Abhishek", "Abhishek"),
				new MyUser("3", "admin", "admin")).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
	}
}
