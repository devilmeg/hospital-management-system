package com.hms.hospital_management.repository.analytics;

import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.entity.Nurse;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface NurseStaffRepository extends JpaRepository<Nurse, Integer> {

    @Query("""
    SELECT new com.hms.hospital_management.dto.response.StaffDTO(
        n.name,
        'Nurse',
        n.position,
        null
    )
    FROM Nurse n
""")
    List<StaffDTO> getNurses();
}