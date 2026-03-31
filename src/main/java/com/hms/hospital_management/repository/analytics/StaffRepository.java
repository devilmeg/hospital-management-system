package com.hms.hospital_management.repository.analytics;

import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.entity.Affiliated_With;
import com.hms.hospital_management.entity.Affiliated_WithId;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface StaffRepository extends JpaRepository<Affiliated_With, Affiliated_WithId> {

    @Query("""
        SELECT DISTINCT new com.hms.hospital_management.dto.response.StaffDTO(
            p.name,
            'Physician',
            p.position,
            d.name
        )
        FROM Physician p
        LEFT JOIN Affiliated_With a ON a.physician = p
        LEFT JOIN a.department d
    """)
    List<StaffDTO> getPhysicians();
}