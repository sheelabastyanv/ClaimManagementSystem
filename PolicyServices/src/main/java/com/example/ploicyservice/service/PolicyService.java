package com.example.ploicyservice.service;

import java.util.List;

import com.example.ploicyservice.entity.Policy;

public interface PolicyService {

	Policy addPolicy(Policy policy);

	List<Policy> getAllPolicies();

}
