package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OnCallNurseDTO {

    private String nurseName;
    private Integer floor;
}
