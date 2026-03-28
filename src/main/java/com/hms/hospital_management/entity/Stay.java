package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Stay")
public class Stay {

    @Id
    @Column(name = "StayID")
    private int stayId;

    // FK → Patient
    @ManyToOne
    @JoinColumn(name = "Patient", nullable = false)
    private Patient patient;

    // FK → Room
    @ManyToOne
    @JoinColumn(name = "Room", nullable = false)
    private Room room;

    @Column(name = "StayStart", nullable = false)
    private LocalDateTime stayStart;

    @Column(name = "StayEnd", nullable = false)
    private LocalDateTime stayEnd;
}