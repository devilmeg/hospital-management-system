package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.PrescriptionDTO;
import com.hms.hospital_management.entity.Prescribes;
import com.hms.hospital_management.entity.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrescriptionQueryRepository extends JpaRepository<Prescribes, PrescribesId> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.PrescriptionDTO(
            m.name,
            m.brand,
            pr.dose,
            phy.name
        )
        FROM Prescribes pr
        JOIN pr.medication m
        JOIN pr.physician phy
        WHERE pr.patient.ssn = :ssn
    """)
    List<PrescriptionDTO> getPrescriptions(@Param("ssn") Integer ssn);
}
