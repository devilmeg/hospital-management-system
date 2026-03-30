package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @Column(name = "RoomNumber")
    private int roomNumber;

    @Column(name = "RoomType", nullable = false,length = 30)
    private String roomType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blockFloor", column = @Column(name = "BlockFloor")),
            @AttributeOverride(name = "blockCode", column = @Column(name = "BlockCode"))
    })
//    @EmbeddedId
    private Block_Id blockId;

    @Column(name = "Unavailable", nullable = false)
    private boolean unavailable;
}