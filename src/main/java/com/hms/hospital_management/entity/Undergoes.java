package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Undergoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Undergoes {

    @EmbeddedId
    private UndergoesId id;

    //first go with pk relationship
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("patientId")
    @JoinColumn(name = "Patient", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("procedureId")
    @JoinColumn(name = "Procedures", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Procedures procedure;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("stayId")
    @JoinColumn(name = "Stay", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Stay stay;



    //  NON-PK RELATIONSHIPS


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Physician", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AssistingNurse")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Nurse assistingNurse;
}