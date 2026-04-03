package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.PatientAppointmentDTO;
import com.hms.hospital_management.dto.response.PatientPrescriptionDTO;
import com.hms.hospital_management.dto.response.PatientProfileDTO;
import com.hms.hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientQueryRepository extends JpaRepository<Patient, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.PatientProfileDTO(
            p.ssn,
            p.name,
            p.address,
            p.phone,
            phy.name
        )
        FROM Patient p
        LEFT JOIN p.physician phy
        WHERE p.ssn = :ssn
    """)
    PatientProfileDTO getPatientProfile(@Param("ssn") Integer ssn);

    @Query("""
SELECT new com.hms.hospital_management.dto.response.PatientPrescriptionDTO(
    m.name,
    p.dose,
    phy.name,
    p.prescribesId.date
)
FROM Prescribes p
JOIN p.medication m
JOIN p.physician phy
LEFT JOIN p.appointment a
WHERE p.patient.ssn = :ssn
ORDER BY p.prescribesId.date DESC
""")
    List<PatientPrescriptionDTO> getPatientPrescriptions(@Param("ssn") Integer ssn);
    @Query("""
    SELECT new com.hms.hospital_management.dto.response.PatientAppointmentDTO(
        a.startTo,
        a.endo,
        phy.name,
        NULL
    )
    FROM Appointment a
    LEFT JOIN a.physician phy
    WHERE a.patient.ssn = :ssn
    ORDER BY a.startTo DESC
""")
    List<PatientAppointmentDTO> getAppointments(@Param("ssn") Integer ssn);
}