package com.hms.hospital_management.repository.analytics;

import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.entity.Stay;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface StayAnalyticsRepository extends JpaRepository<Stay, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.RevenueDTO(
            'Room',
            CAST(r.roomNumber AS string),
            COUNT(s),
            COALESCE(SUM(
                FUNCTION('TIMESTAMPDIFF', DAY, s.stayStart, s.stayEnd)
            ), 0)
        )
        FROM Stay s
        JOIN s.room r
        GROUP BY r.roomNumber
    """)
    List<RevenueDTO> getRoomRevenue();
}