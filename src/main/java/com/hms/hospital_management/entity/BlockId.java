package com.hms.hospital_management.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockId implements Serializable {

    private int blockFloor;
    private int blockCode;
}