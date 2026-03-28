package com.hms.hospital_management.entity;
<<<<<<< HEAD

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
>>>>>>> 016a7a7b1c5122e2bb993835c924a6f19a9ec9e8

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @Column(name = "SSN",nullable = false)
    private Integer ssn;

    @Column(name = "Name",nullable = false, length=30)
    private String name;

    @Column(name = "Address",nullable = false, length=30)
    private String address;

    @Column(name = "Phone",nullable = false, length=30)
    private String phone;

    @Column(name = "InsuranceID",nullable = false)
    private Integer insuranceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PCP")
    private Physician physician;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<Stay> stays;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<Prescribes> prescription;

}