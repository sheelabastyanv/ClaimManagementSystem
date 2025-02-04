package com.example.claimservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.claimservice.entity.Claim;
import com.example.claimservice.model.ClaimStatus;
import com.example.claimservice.service.ClaimService;

@RestController
@RequestMapping("/claim")
public class ClaimController {

	@Autowired
	ClaimService claimService;

	/**
	 * Creates a new claim for the specified user and policy.
	 */

	@PostMapping("/create/{userId}/{policyId}")
	public ResponseEntity<String> createClaim(@PathVariable Long userId, @PathVariable Long policyId) {

		claimService.createClaim(userId, policyId);
		return ResponseEntity.ok("Claim request submitted successfully.");

	}

	/**
	 * Retrieves the status of a claim by its ID.
	 */

	@GetMapping("/status/{claimId}")
	public String getClaimStatus(@PathVariable Long claimId) {
		return claimService.getClaimStatus(claimId);
	}

	@GetMapping("/pending")
	public ResponseEntity<List<Claim>> getPendingClaim() {
		List<Claim> pendingClaims = claimService.getPendingClaim();
		return ResponseEntity.ok(pendingClaims);
	}

	@PutMapping("/updateStatus/{claimId}/{status}")
	public ResponseEntity<String> updateClaimStatus(@PathVariable Long claimId, @PathVariable ClaimStatus status) {
		claimService.updateClaimStatus(claimId, status);
		return ResponseEntity.ok("Claim status updated to " + status);
	}

}
