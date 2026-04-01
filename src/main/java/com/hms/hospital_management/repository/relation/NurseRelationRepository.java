package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.dto.response.DoctorPatientDTO;
import com.hms.hospital_management.entity.Undergoes;
import com.hms.hospital_management.entity.UndergoesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NurseRelationRepository extends JpaRepository<Undergoes, UndergoesId> {

    @Query("""
        SELECT DISTINCT new com.hms.hospital_management.dto.response.DoctorPatientDTO(
            p.ssn,
            p.name
        )
        FROM Undergoes u
        JOIN u.patient p
        WHERE u.assistingNurse.employeeId = :id
    """)
    List<DoctorPatientDTO> getNursePatients(@Param("id") Integer id);
}