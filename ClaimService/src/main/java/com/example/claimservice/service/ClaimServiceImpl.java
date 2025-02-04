package com.example.claimservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.claimservice.entity.Claim;
import com.example.claimservice.entity.PolicyServiceClient;
import com.example.claimservice.exception.ClaimNotFoundException;
import com.example.claimservice.model.ClaimStatus;
import com.example.claimservice.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	PolicyServiceClient policyServiceClient;

	@Override
	public void createClaim(Long userId, Long policyId) {

		boolean policyExists = policyServiceClient.doesPolicyExist(policyId);

		if (!policyExists) {
			throw new RuntimeException("policy not found");
		}
		Claim claim = new Claim();
		claim.setUserId(userId);
		claim.setPolicyId(policyId);
		claim.setStatus(ClaimStatus.PENDING);
		claimRepository.save(claim);
	}

	@Override
	public String getClaimStatus(Long claimId) {
		// Claim claim = claimRepository.findById(claimId).orElseThrow(() -> new
		// ClaimNotFoundException("" +claimId));

		// return claim.getStatus().name();
		Optional<Claim> claimOptional = claimRepository.findById(claimId);
		Claim claim = claimOptional
				.orElseThrow(() -> new ClaimNotFoundException("Claim not found with ID: " + claimId));
		return claim.getStatus().name();

	}

	@Override
	public List<Claim> getPendingClaim() {

		return claimRepository.findByStatus(ClaimStatus.PENDING);
	}

	public void updateClaimStatus(Long claimId, ClaimStatus status) {

		Optional<Claim> claimOptional = claimRepository.findById(claimId);
		Claim claim = claimOptional
				.orElseThrow(() -> new ClaimNotFoundException("Claim not found with ID: " + claimId));
		claim.setStatus(status);
		claimRepository.save(claim);
	}
}