package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.PatientAppointmentDTO;
import com.hms.hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentQueryRepository extends JpaRepository<Appointment, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.PatientAppointmentDTO(
            a.startTo,
            phy.name
        )
        FROM Appointment a
        JOIN a.physician phy
        WHERE a.patient.ssn = :ssn
        ORDER BY a.startTo DESC
    """)
    List<PatientAppointmentDTO> getAppointments(@Param("ssn") Integer ssn);
}