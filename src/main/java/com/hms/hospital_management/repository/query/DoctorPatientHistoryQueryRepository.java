package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorPatientHistoryQueryRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a " +
            "WHERE a.patient.ssn = :ssn " +
            "ORDER BY a.startTo DESC") // Note: Use startTo, not startDatetime based on your entity
    List<Appointment> findAllHistoryByPatientSSN(@Param("ssn") Integer ssn);
}
