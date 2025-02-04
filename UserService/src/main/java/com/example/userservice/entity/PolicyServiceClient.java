package com.example.userservice.entity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * PolicyServiceClient is a Feign client interface for communicating with the POLICY-SERVICE.
 * It provides methods to interact with the POLICY-SERVICE API.
 */
@FeignClient(name = "POLICY-SERVICE")
public interface PolicyServiceClient {
	
	/**
     * Checks if a policy exists in the POLICY-SERVICE.
     */

	@GetMapping("/policy/exist/{policyId}")
	boolean doesPolicyExist(@PathVariable Long policyId);

}
