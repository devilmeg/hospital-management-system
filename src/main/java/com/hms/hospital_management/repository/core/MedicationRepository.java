package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}