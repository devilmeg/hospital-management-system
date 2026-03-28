package com.hms.hospital_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Procedures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Procedures {
    @Id
    @Column(name = "Code")
    private int code;

    @Column(name  = "Name", nullable = false)
    private String name;

    @Column(name = "Cost", nullable = false)
    private Double cost;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY)
    @JsonIgnore // Prevents infinite loop in JSON
    private List<Trained_In> trainedDoctors;

    @OneToMany(mappedBy = "procedure",  fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Undergoes> patientHistory;
}
