package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.DoctorProcedureDTO;
import com.hms.hospital_management.entity.Trained_In;
import com.hms.hospital_management.entity.Trained_InId;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorProcedureRepository extends JpaRepository<Trained_In, Trained_InId> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.DoctorProcedureDTO(
            p.name,
            p.cost
        )
        FROM Trained_In t
        JOIN t.procedure p
        WHERE t.physician.employeeID = :id
    """)
    List<DoctorProcedureDTO> getTrainedProcedures(@Param("id") Integer id);
}