package com.hms.hospital_management.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class On_Call_Id implements Serializable {
    private LocalDateTime onCallStart;
    private LocalDateTime onCallEnd;
    private Integer  nurse;
    private Integer blockFloor;
    private Integer blockCode;


}
