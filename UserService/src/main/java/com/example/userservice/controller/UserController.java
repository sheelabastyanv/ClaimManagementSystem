package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	// This method is for User registration
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
		User savedUser = userService.registerUser(user);
		return ResponseEntity.ok(savedUser);
	}

	// User can apply for particular policy by mentioning the policyId
	@PostMapping("/applypolicy/{userId}/{policyId}")
	public ResponseEntity<String> applyPolicy(@PathVariable Long userId, @PathVariable Long policyId) {
		userService.applyPolicy(userId, policyId);
		return ResponseEntity.ok("Policy applied successfully");
	}

	// User can get the list of all his policies by his userId
	@GetMapping("/myPolicies/{userId}")
	public ResponseEntity<List<Long>> getUserPolicies(@PathVariable Long userId) {
		List<Long> policies = userService.getUserPolicies(userId);
		return ResponseEntity.ok(policies);
	}

}
