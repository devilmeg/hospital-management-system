package com.hms.hospital_management.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hms.hospital_management.constants.AppConstants;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class NurseOnCallDTO {

    private String nurseName;
    private Integer blockFloor;
    private Integer blockCode;

    @JsonFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime start;

    @JsonFormat(pattern = AppConstants.DATE_TIME_FORMAT)
    private LocalDateTime end;


    public NurseOnCallDTO(String nurseName,
                          Integer blockFloor,
                          Integer blockCode,
                          LocalDateTime start,
                          LocalDateTime end) {
        this.nurseName = nurseName;
        this.blockFloor = blockFloor;
        this.blockCode = blockCode;
        this.start = start;
        this.end = end;
    }
}