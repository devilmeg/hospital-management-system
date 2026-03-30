package com.hms.hospital_management.repository.impl;

import com.hms.hospital_management.repository.analytics.ReportRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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