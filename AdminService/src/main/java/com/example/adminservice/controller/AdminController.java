package com.example.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adminservice.entity.Admin;
import com.example.adminservice.service.AdminService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	/**
	 * Registers a new admin.
	 */

	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) {
		Admin registeredAdmin = adminService.registerAdmin(admin);
		return ResponseEntity.ok(registeredAdmin);
	}

	/**
	 * Approves a claim by its ID.
	 */

	@PutMapping("/approveClaim/{claimId}")
	public ResponseEntity<String> approveClaim(@PathVariable Long claimId) {
		adminService.approveClaim(claimId);
		return ResponseEntity.ok("Claim approved successfully.");
	}

	/**
	 * Rejects a claim by its ID.
	 */
	@PutMapping("/rejectClaim/{claimId}")
	public ResponseEntity<String> rejectClaim(@PathVariable Long claimId) {
		adminService.rejectClaim(claimId);
		return ResponseEntity.ok("Claim rejected successfully.");
	}
}
