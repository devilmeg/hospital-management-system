package com.hms.hospital_management.entity;

import jakarta.persistence.*;
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
    @Column(name = "OnCallStart")
    private LocalDateTime onCallStart;

    @Column(name = "OnCallEnd")
    private LocalDateTime onCallEnd;

    @Column(name = "Nurse")
    private Integer nurse;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blockFloor", column = @Column(name = "BlockFloor")),
            @AttributeOverride(name = "blockCode", column = @Column(name = "BlockCode"))
    })
    private Block_Id blockId;


}
