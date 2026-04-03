package com.hms.hospital_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.entity.Appointment;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Data Transfer Object representing a simplified view of  appointments .
 * <p>
 * This DTO aggregates information from Appointments, Patient, and nurse
 * into a flat structure
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAppointmentDTO {
    /** Appointment id for the patient */
    private Integer appointmentId;
    /** Patient Name  */
    private String patientName;
    /** Room to Examine the Patient*/
    private String room;
    /** Doctor attending the patient */
    private String drName;
    /** Nurse name attending the patient*/
    private String nurseName;
    /** Date of the appointment event in YYYY-MM-DD format. */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    /**
     * Maps an {@link Appointment} to {@link DoctorAppointmentDTO}
     * <p>
     *     Performs the safety check  null fields
     * </p>
     * @param entity the source appointment of a patient
     */
    public DoctorAppointmentDTO(Appointment entity) {
        if (entity != null) {
            this.appointmentId = entity.getAppointmentId();
            this.patientName = entity.getPatient() != null ? entity.getPatient().getName() : "Unknown";
            this.room = entity.getExaminationRoom();
            this.drName = entity.getPhysician() != null ? entity.getPhysician().getName() : "N/A";

            this.nurseName = entity.getPrepNurse() != null ? entity.getPrepNurse().getName() : "No Nurse Assigned";

            this.appointmentTime = entity.getStartTo();
        }
    }
}
