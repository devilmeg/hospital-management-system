package com.hms.hospital_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Trained_InId implements Serializable {
    @Column(name = "Physician")
    Integer physician;

    @Column(name = "Treatment")
    Integer treatment;
}
