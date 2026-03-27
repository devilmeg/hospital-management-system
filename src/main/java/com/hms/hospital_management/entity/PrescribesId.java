package com.hms.hospital_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Date;

@Embeddable
@EqualsAndHashCode
public class PrescribesId implements Serializable {
    @Column(name = "Physician" )
    private Integer physician;

    @Column(name = "Patient")
    private Integer patient;

    @Column(name = "Medication")
    private Integer medication;

    @Column(name = "Date")
    private Date date;
}
