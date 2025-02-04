package com.example.ploicyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ploicyservice.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

	boolean existsById(Long policyId);

}
