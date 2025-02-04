package com.example.userservice.service;

import java.util.List;

import com.example.userservice.entity.User;

public interface UserService {

	void applyPolicy(Long userId, Long policyId);

	User registerUser(User user);

	List<Long> getUserPolicies(Long userId);

}
