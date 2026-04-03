package com.hms.hospital_management.dto.response;

import com.hms.hospital_management.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;


/**
 * Data Transfer Object representing a simplified view of a patient's medical history.
 * <p>
 * This DTO aggregates information from Appointments, Physicians, and Prescriptions
 * into a flat structure suitable for the "Astral" themed UI display.
 * </p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientHistoryDto {
    /** Date of the medical event in YYYY-MM-DD format. */
    private String date;
    /** Type of medical interaction (e.g. CONSULTATION, SURGERY). */
    private String eventType;
    /** Detailed summary of medications or procedures performed. */
    private String description;
    /** Formatted name of the attending physician (e.g "Dr. Turk"). */
    private String physician;
    /** Summary of outcome or location (e.g., "Room: 101"). */
    private String results;

    /**
     * Maps an {@link Appointment} entity to this DTO.
     * <p>
     * Performs safety checks for null fields and formats prescriptions into a
     * single pipe-separated string for the UI.
     *
     * @param app the source Appointment entity to transform
     */
    public DoctorPatientHistoryDto(Appointment app) {
        this.date = app.getStartTo() != null
                ? app.getStartTo().toLocalDate().toString()
                : "N/A";
        this.eventType = "CONSULTATION";
        this.physician = app.getPhysician() != null
                ? "Dr. " + app.getPhysician().getName()
                : "Unknown";
        // Using Examination Room as a 'result' or status for the Astral UI
        this.results = "Room: " + (app.getExaminationRoom() != null
                ? app.getExaminationRoom()
                : "TBD");
        if (app.getPrescriptions() != null && !app.getPrescriptions().isEmpty()) {
            this.description = "RX: " + app.getPrescriptions().stream()
                    .filter(p -> p.getMedication() != null) // Safety check
                    .map(p -> p.getMedication().getName() + " (" + p.getDose() + ")")
                    .collect(Collectors.joining(" | ")); // Stylish separator for Astral theme
        } else {
            this.description = "No medication issued for this session.";
        }
    }
}