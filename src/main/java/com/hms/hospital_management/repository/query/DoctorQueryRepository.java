package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.DoctorPatientDTO;
import com.hms.hospital_management.entity.Prescribes;
import com.hms.hospital_management.entity.PrescribesId;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DoctorQueryRepository extends JpaRepository<Prescribes, PrescribesId> {

    @Query("""
        SELECT DISTINCT new com.hms.hospital_management.dto.response.DoctorPatientDTO(
            p.ssn,
            p.name
        )
        FROM Patient p
        WHERE p.physician.employeeID = :id
    """)
    Page<DoctorPatientDTO> getDoctorPatients(@Param("id") Integer id, Pageable pageable);
}
