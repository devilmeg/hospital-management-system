package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.DoctorAppointmentDTO;
import com.hms.hospital_management.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorAppointmentQueryRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a " +
            "JOIN FETCH a.patient p " +
            "WHERE a.physician.employeeID = :id")
    Page<Appointment> getTodayAppointments(@Param("id") Integer id, Pageable pageable);
}
