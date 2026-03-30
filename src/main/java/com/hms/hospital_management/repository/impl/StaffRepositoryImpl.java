package com.hms.hospital_management.repository.impl;

import com.hms.hospital_management.repository.analytics.StaffRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StaffRepositoryImpl implements StaffRepository {

    private final EntityManager em;

    public List<Object[]> getAllStaff() {
        return em.createNativeQuery("""
            SELECT name, position FROM physician
            UNION
            SELECT name, position FROM nurse
        """).getResultList();
    }
}
