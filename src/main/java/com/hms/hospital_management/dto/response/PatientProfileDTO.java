package com.hms.hospital_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientProfileDTO {

    private String name;
    private String address;
    private String phone;
    private String primaryDoctor;
}