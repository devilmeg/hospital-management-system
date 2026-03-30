package com.hms.hospital_management.repository.impl;

import com.hms.hospital_management.repository.query.PhysicianQueryRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PhysicianQueryRepositoryImpl implements PhysicianQueryRepository {

    private final EntityManager em;

    public List<Object[]> getDoctorPatients(Integer id) {
        return em.createNativeQuery("""
            SELECT DISTINCT p.name
            FROM patient p
            JOIN prescribes pr ON p.ssn = pr.patient
            WHERE pr.physician = :id
        """).setParameter("id", id).getResultList();
    }

    public List<Object[]> getTodayAppointments(Integer id) {
        return em.createNativeQuery("""
            SELECT p.name, a.starto
            FROM appointment a
            JOIN patient p ON a.patient = p.ssn
            WHERE a.physician = :id
        """).setParameter("id", id).getResultList();
    }

    public List<Object[]> getDoctorProcedures(Integer id) {
        return em.createNativeQuery("""
            SELECT pr.name
            FROM trained_in t
            JOIN procedures pr ON t.treatment = pr.code
            WHERE t.physician = :id
        """).setParameter("id", id).getResultList();
    }
}
