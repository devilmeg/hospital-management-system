package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "Trained_In")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trained_In {
    @EmbeddedId
    private Trained_InId trainedInId;

    @ManyToOne
    @MapsId("physician")
    @JoinColumn(name = "Physician", nullable = false)
    private Physician physician;

    @ManyToOne
    @MapsId("treatment")
    @JoinColumn(name = "Treatment", nullable = false)
    private Procedures procedure;


    @Column(name = "CertificationDate", nullable = false)
    private LocalDateTime certificationDate;

    @Column(name = "CertificationExpires", nullable = false)
    private LocalDateTime certificationExpires;
}