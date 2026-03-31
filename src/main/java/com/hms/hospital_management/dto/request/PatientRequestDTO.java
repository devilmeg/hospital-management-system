package com.hms.hospital_management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDTO {

    private String name;
    private String address;
    private String phone;
    private Integer insuranceId;
    private Integer primaryPhysicianId;
}