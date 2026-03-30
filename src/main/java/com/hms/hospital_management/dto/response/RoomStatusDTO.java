package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomStatusDTO {

    private Integer roomNumber;
    private Boolean unavailable;
    private Integer floor;
}
