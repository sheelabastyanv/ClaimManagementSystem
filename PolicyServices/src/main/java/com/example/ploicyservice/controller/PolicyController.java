package com.example.ploicyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ploicyservice.entity.Policy;
import com.example.ploicyservice.repository.PolicyRepository;
import com.example.ploicyservice.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@Autowired
	PolicyRepository policyRepository;

	// policies are added by the admin.
	@PostMapping("/add")
	public ResponseEntity<Policy> addPolicy(@Valid @RequestBody Policy policy) {
		Policy savedPolicy = policyService.addPolicy(policy);
		return ResponseEntity.ok(savedPolicy);
	}

	// we can get all the policies added by the admin.
	@GetMapping("/all")
	public List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}

	// this method is to check whether the policy exist for particular policyId
	@GetMapping("/exist/{policyId}")
	public ResponseEntity<Boolean> doesPolicyExist(@PathVariable Long policyId) {
		boolean exists = policyRepository.existsById(policyId);
		return ResponseEntity.ok(exists);
	}

}
