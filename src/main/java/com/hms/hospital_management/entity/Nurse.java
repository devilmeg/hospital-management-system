package com.hms.hospital_management.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Nurse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nurse {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Position", nullable = false, length = 30)
    private String position;

    @Column(name = "Registered", nullable = false)
    private Boolean registered;

    @Column(name = "SSN", nullable = false)
    private Integer ssn;

    //  Nurse ->> Appointment (PrepNurse)
    @OneToMany(mappedBy = "prepNurse", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Appointment> appointments = new ArrayList<>();

    // Nurse ->> Undergoes (AssistingNurse)
    @OneToMany(mappedBy = "assistingNurse", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Undergoes> undergoes = new ArrayList<>();

    //  Nurse ->> OnCall
    @OneToMany(mappedBy = "nurse", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<On_Call> onCalls = new ArrayList<>();
}