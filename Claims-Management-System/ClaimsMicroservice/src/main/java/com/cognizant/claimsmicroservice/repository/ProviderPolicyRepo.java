package com.cognizant.claimsmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimsmicroservice.model.ProviderPolicy;

@Repository
public interface ProviderPolicyRepo extends JpaRepository<ProviderPolicy, Integer> {
	List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int policyId);
}