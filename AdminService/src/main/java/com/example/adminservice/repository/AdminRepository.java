package com.example.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adminservice.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
