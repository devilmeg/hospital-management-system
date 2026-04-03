package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.AppointmentByDateDTO;
import com.hms.hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDateRepository extends JpaRepository<Appointment, Integer> {

    @Query("""
    SELECT new com.hms.hospital_management.dto.response.AppointmentByDateDTO(
        p.name,
        ph.name,
        a.examinationRoom,
        a.startTo
    )
    FROM Appointment a
    JOIN a.patient p
    JOIN a.physician ph
    WHERE FUNCTION('DATE', a.startTo) = :date
""")
    List<AppointmentByDateDTO> getAppointmentsByDate(LocalDate date);
}