package com.example.claimservice.entity;

import com.example.claimservice.model.ClaimStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "claims")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;
	@NotNull(message = "User ID is mandatory")
	private Long userId;
	@NotNull(message = "Policy ID is mandatory")
	private Long policyId;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Claim status is mandatory")
	private ClaimStatus status;

	private double claimAmount;

}