package com.example.ploicyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ploicyservice.entity.Policy;
import com.example.ploicyservice.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepository policyRepository;

	@Override
	public Policy addPolicy(Policy policy) {

		return policyRepository.save(policy);
	}

	@Override
	public List<Policy> getAllPolicies() {

		return policyRepository.findAll();
	}

}
