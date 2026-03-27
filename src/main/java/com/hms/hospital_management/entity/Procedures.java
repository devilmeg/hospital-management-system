package com.hms.hospital_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
}
