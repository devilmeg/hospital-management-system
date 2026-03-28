package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Medication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medication {

    @Id
    @Column(name = "Code")
    private int code;

    @NotBlank(message = "Medication name cannot be empty")
    @Column(name = "Name", nullable = false,length = 30)
    private String name;

    @NotBlank(message = "Brand cannot be empty")
    @Column(name = "Brand", nullable = false,length = 30)
    private String brand;

    @NotBlank(message = "Description cannot be empty")
    @Column(name = "Description", nullable = false,length = 30)
    private String description;

    //  Relationship with Prescribes (One Medication → Many Prescriptions)
    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prescribes> prescriptions;
}