package com.hms.hospital_management.repository.impl;

import com.hms.hospital_management.repository.analytics.ReportRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryImpl implements ReportRepository {

    private final EntityManager em;

    public List<Object[]> getRevenueReport() {
        return em.createNativeQuery("""
            SELECT pr.name, SUM(pr.cost)
            FROM undergoes u
            JOIN procedures pr ON u.procedures = pr.code
            GROUP BY pr.name
        """).getResultList();
    }
}