package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.DoctorProcedureDTO;
import com.hms.hospital_management.entity.Trained_In;
import com.hms.hospital_management.entity.Trained_InId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorProcedureRepository extends JpaRepository<Trained_In, Trained_InId> {

    @Query(value = """
        SELECT t FROM Trained_In t 
        JOIN t.procedure p 
        WHERE t.physician.employeeID = :id
    """,
            countQuery = "SELECT count(t) FROM Trained_In t WHERE t.physician.employeeID = :id")
    Page<Trained_In> getTrainedProcedures(@Param("id") Integer id, Pageable pageable);
}