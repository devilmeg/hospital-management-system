package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {

    // Find by name
    List<Nurse> findByName(String name);

    // Find by position (e.g., "Senior Nurse")
    List<Nurse> findByPosition(String position);

    // Find registered nurses
    List<Nurse> findByRegisteredTrue();

    // Find by SSN
    Nurse findBySsn(int ssn);
}