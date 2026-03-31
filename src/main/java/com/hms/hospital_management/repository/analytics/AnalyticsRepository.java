package com.hms.hospital_management.repository.analytics;

import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.entity.Undergoes;
import com.hms.hospital_management.entity.UndergoesId;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface AnalyticsRepository extends JpaRepository<Undergoes, UndergoesId> {
    @Query("""
    SELECT new com.hms.hospital_management.dto.response.RevenueDTO(
        'Procedure',
        pr.name,
        COUNT(u),
        SUM(pr.cost)
    )
    FROM Undergoes u
    JOIN u.procedure pr
    GROUP BY pr.name
""")
    List<RevenueDTO> getRevenueReport();
}