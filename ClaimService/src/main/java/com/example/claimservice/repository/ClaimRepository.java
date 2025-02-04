package com.example.claimservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.claimservice.entity.Claim;
import com.example.claimservice.model.ClaimStatus;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	List<Claim> findByStatus(ClaimStatus pending);

}
