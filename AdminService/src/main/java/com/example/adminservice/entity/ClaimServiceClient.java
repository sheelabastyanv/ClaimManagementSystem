package com.example.adminservice.entity;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "CLAIM-SERVICE")
public interface ClaimServiceClient {

	@GetMapping("/claim/pending")
	List<Map<String, Object>> getPendingClaims();

	@PutMapping("/claim/updateStatus/{claimId}/APPROVED")
	void approveClaim(@PathVariable Long claimId);

	@PutMapping("/claim/updateStatus/{claimId}/REJECTED")
	void rejectClaim(@PathVariable Long claimId);

}
