package com.example.claimservice.entity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="POLICY-SERVICE")
public interface PolicyServiceClient {
	
	@GetMapping("/policy/exist/{policyId}")
	boolean doesPolicyExist(@PathVariable long policyId);

}
