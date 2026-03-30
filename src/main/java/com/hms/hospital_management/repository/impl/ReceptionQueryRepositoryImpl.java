package com.hms.hospital_management.repository.impl;


import com.hms.hospital_management.repository.query.ReceptionQueryRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReceptionQueryRepositoryImpl implements ReceptionQueryRepository {

    private final EntityManager em;

    public List<Object[]> getRoomStatus() {
        return em.createNativeQuery("SELECT roomnumber, unavailable FROM room")
                .getResultList();
    }

    public List<Object[]> getAppointmentsByDate(LocalDate date) {
        return em.createNativeQuery("""
            SELECT appointmentid
            FROM appointment
            WHERE DATE(starto) = :date
        """).setParameter("date", date).getResultList();
    }

    public List<Object[]> getOnCallNurses() {
        return em.createNativeQuery("""
            SELECT n.name
            FROM nurse n
            JOIN on_call o ON n.employeeid = o.nurse
        """).getResultList();
    }
}
