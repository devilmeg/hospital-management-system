package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomStatusDTO {

    private Integer roomNumber;
    private String status;


    public RoomStatusDTO(Integer roomNumber, Object unavailable) {
        this.roomNumber = roomNumber;

        Boolean flag = false;

        if (unavailable instanceof Boolean) {
            flag = (Boolean) unavailable;
        }

        this.status = flag ? "UNAVAILABLE" : "AVAILABLE";
    }
}
