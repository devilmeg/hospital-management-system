package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.PatientStayHistoryDTO;
import com.hms.hospital_management.entity.Stay;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StayQueryRepository extends JpaRepository<Stay, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.PatientStayHistoryDTO(
            r.roomNumber,
            r.roomType,
            s.stayStart,
            s.stayEnd
        )
        FROM Stay s
        JOIN s.room r
        WHERE s.patient.ssn = :ssn
        ORDER BY s.stayStart DESC
    """)
    List<PatientStayHistoryDTO> getStayHistory(@Param("ssn") Integer ssn);
}