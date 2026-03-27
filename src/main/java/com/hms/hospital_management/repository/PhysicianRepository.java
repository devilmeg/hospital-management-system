package com.hms.hospital_management.repository;

import com.hms.hospital_management.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
}
