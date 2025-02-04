package com.example.adminservice.service;

import com.example.adminservice.entity.Admin;

public interface AdminService {

	void approveClaim(Long claimId);

	void rejectClaim(Long claimId);

	Admin registerAdmin(Admin admin);

}
