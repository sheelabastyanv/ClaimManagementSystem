package com.example.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.adminservice.entity.Admin;
import com.example.adminservice.entity.ClaimServiceClient;
import com.example.adminservice.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ClaimServiceClient claimServiceClient;

	public void approveClaim(Long claimId) {
		claimServiceClient.approveClaim(claimId);
	}

	public void rejectClaim(Long claimId) {
		claimServiceClient.rejectClaim(claimId);
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
}
