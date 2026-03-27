package com.hms.hospital_management.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Patient")
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
}