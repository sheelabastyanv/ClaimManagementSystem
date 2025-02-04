package com.example.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.entity.PolicyServiceClient;
import com.example.userservice.entity.User;
import com.example.userservice.exception.PolicyNotFoundException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PolicyServiceClient policyServiceClient;

	@Override
	public void applyPolicy(Long userId, Long policyId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID:" + userId));

		if (!policyServiceClient.doesPolicyExist(policyId)) {
			throw new PolicyNotFoundException("policy not found with ID:" + policyId);
		}

		user.getAppliedPolicies().add(policyId);
		userRepository.save(user);

	}

	@Override
	public User registerUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<Long> getUserPolicies(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID:" + userId));
		return user.getAppliedPolicies();
	}

}
