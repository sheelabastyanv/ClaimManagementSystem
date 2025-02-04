package com.example.ploicyservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "policies")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;

	@NotBlank(message = "Policy name is mandatory")
	@Size(max = 100, message = "Policy name should not exceed 100 characters")
	private String policyName;

	@Size(max = 500, message = "Description should not exceed 500 characters")
	private String description;

	private double coverageAmount;
	private double premiumAmount;

}
