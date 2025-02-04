package com.example.claimservice.service;

import java.util.List;

import com.example.claimservice.entity.Claim;
import com.example.claimservice.model.ClaimStatus;

public interface ClaimService {

	void createClaim(Long userId, Long policyId);

	String getClaimStatus(Long claimId);

	List<Claim> getPendingClaim();

	void updateClaimStatus(Long claimId, ClaimStatus status);

}
