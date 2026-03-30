package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "On_Call")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class On_Call {
    @EmbeddedId
    private On_Call_Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nurse")
    @JoinColumn(name = "Nurse", referencedColumnName = "EmployeeID" ,nullable = false)
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("blockId")
    @JoinColumns({
            @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor"),
            @JoinColumn(name = "BlockCode", referencedColumnName = "BlockCode")
    })
    private Block block;

}
