package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.PatientProfileDTO;
import com.hms.hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientQueryRepository extends JpaRepository<Patient, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.PatientProfileDTO(
            p.ssn,
            p.name,
            p.address,
            p.phone,
            phy.name
        )
        FROM Patient p
        LEFT JOIN p.physician phy
        WHERE p.ssn = :ssn
    """)
    PatientProfileDTO getPatientProfile(@Param("ssn") Integer ssn);
}