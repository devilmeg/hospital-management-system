package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {
}