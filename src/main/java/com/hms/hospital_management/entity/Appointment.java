package com.hms.hospital_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @Column(name = "AppointmentID")
    private int appointmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PrepNurse")
    private Nurse prepNurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", nullable = false)
    private Physician physician;

    @Column(name = "Starto", nullable = false)
    private LocalDateTime startTo;

    @Column(name = "Endo", nullable = false)
    private LocalDateTime endo;

    @Column(name = "ExaminationRoom", nullable = false, columnDefinition = "TEXT")
    private String examinationRoom;

    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY)
    @JsonIgnore // Important to prevent infinite recursion in JSON
    private List<Prescribes> prescriptions;

}
