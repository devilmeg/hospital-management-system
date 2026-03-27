package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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

    @ManyToOne
    @JoinColumn(name = "Patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "PrepNurse")
    private Nurse prepNurse;

    @ManyToOne
    @JoinColumn(name = "Physician", nullable = false)
    private Physician physician;

    @Column(name = "Starto", nullable = false)
    private Date startTo;

    @Column(name = "Endo", nullable = false)
    private Date endo;

    @Column(name = "ExaminationRoom", nullable = false)
    private String examinationRoom;


}
