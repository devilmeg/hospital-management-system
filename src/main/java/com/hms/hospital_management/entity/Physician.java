package com.hms.hospital_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import lombok.*;
>>>>>>> 016a7a7b1c5122e2bb993835c924a6f19a9ec9e8

@Entity
@Table(name = "Physician")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Physician {

    @Id
    @Column(name = "EmployeeID",nullable = false)
    private Integer employeeID;
    @Column(name = "Name",nullable = false, length = 30)
    private String name;
    @Column(name = "Position",nullable = false, length=30)
    private String position;
    @Column(name = "SSN",nullable = false)
    private Integer ssn;
<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "physician")
    private List<Appointment> appointments;
>>>>>>> 016a7a7b1c5122e2bb993835c924a6f19a9ec9e8
}