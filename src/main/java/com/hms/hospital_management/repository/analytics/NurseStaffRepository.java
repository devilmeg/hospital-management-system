package com.hms.hospital_management.repository.analytics;

import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.entity.Nurse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseStaffRepository extends JpaRepository<Nurse, Integer> {

//    @Query("""
//    SELECT new com.hms.hospital_management.dto.response.StaffDTO(
//        n.name,
//        'Nurse',
//        n.position,
//        null
//    )
//    FROM Nurse n
//""")
//    List<StaffDTO> getNurses();

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.StaffDTO(
            n.name,
            'Nurse',
            n.position,
            null,
            null,
            null
        )
        FROM Nurse n
    """)
    List<StaffDTO> getNurses();
}