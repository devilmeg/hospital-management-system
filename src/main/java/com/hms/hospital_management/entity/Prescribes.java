package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Prescribes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescribes {
    @EmbeddedId
    private PrescribesId prescribesId;

    @ManyToOne
    @MapsId("physician")
    @JoinColumn(name = "Physician", nullable = false)
    private Physician physician;

    @ManyToOne
    @MapsId("patient")
    @JoinColumn(name = "Patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @MapsId("medication")
    @JoinColumn(name = "Medication", nullable = false)
    private Medication medication;

    @ManyToOne
    @JoinColumn(name  = "Appointment")
    private Appointment appointment;

    @Column(name = "Dose" , nullable = false)
    private String dose;
}
