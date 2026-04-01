package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.DoctorAppointmentDTO;
import com.hms.hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorAppointmentQueryRepository extends JpaRepository<Appointment, Integer> {

    @Query("""
    SELECT new com.hms.hospital_management.dto.response.DoctorAppointmentDTO(
        p.name,
        a.examinationRoom,
        a.startTo
    )
    FROM Appointment a
    JOIN a.patient p
    WHERE a.physician.employeeID = :id
""")
    List<DoctorAppointmentDTO> getTodayAppointments(Integer id);
}
