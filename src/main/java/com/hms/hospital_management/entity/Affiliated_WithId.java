package com.hms.hospital_management.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Affiliated_WithId implements Serializable {

    private Integer physician;
    private Integer department;
}
