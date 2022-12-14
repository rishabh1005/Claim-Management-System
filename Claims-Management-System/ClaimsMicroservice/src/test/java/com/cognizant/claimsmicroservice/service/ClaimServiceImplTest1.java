package com.cognizant.claimsmicroservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.claimsmicroservice.client.PolicyClient;
import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimServiceImplTest1 {

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	@Mock
	private ClaimRepository claimRepoMock;

	@Mock
	private PolicyClient policyClient;

	@Mock
	private ClaimStatusDTO claimDto;

	@Mock
	private Claim claim;

	@BeforeEach
	void setUp() throws Exception {
		claim = new Claim();
		claim.setClaimId(2);
		claim.setClaimStatus("Pending Action");
		claim.setDescription("claim has been submitted! Please check after few days for confirmation");
		claim.setPolicyId(1);
		claim.setBenefitId(202);
		claim.setMemberId(1);
		claim.setProviderId(1);
		claim.setAmountClaimed(60000.0);
		claim.setAmountSettled(60000.0);
		claimDto.setClaimStatus("Pending Action");
		claimDto.setDescription("claim has been submitted! Please check after few days for confirmation");
	}

	@Test
	void claimServiceImplNotNullTest() {
		assertNotNull(claimServiceImpl);
	}

	@Test
	void testGetClaimStatus_negative() throws ProviderNotFoundException {
		when(claimRepoMock.getById(2)).thenReturn(claim);
		ProviderNotFoundException thrown = Assertions.assertThrows(ProviderNotFoundException.class,
				() -> claimServiceImpl.getClaimStatus(2, 1, 3));
		assertEquals("provider not found", thrown.getMessage());
	}
}