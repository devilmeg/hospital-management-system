package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    private String name;
    private String role;
    private String position;
    private String departmentName;
}
