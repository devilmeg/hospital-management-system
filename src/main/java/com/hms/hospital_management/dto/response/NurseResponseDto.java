package com.hms.hospital_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NurseResponseDto {

    private Integer nurseId;
    private String nurseName;
    private Integer blockFloor;
    private Integer blockCode;
}