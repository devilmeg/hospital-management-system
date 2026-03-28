package com.hms.hospital_management.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.*;

import java.util.List;


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

    @OneToMany(mappedBy = "physician")
    private List<Appointment> appointments;

}
