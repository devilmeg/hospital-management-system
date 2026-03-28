package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Affiliated_With")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Affiliated_With {

    @EmbeddedId
    private Affiliated_WithId id;

    // Physician mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("physician")
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID")
    private Physician physician;

    // Department mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("department")
    @JoinColumn(name = "Department", referencedColumnName = "DepartmentID")
    private Department department;

    @Column(name = "PrimaryAffiliation", nullable = false)
    private Boolean primaryAffiliation;

}
