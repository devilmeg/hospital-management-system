package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffDTO {

    private String name;
    private String role;
    private String position;
    private String departmentName;
    private Boolean primaryAffiliation;
    private Boolean isDepartmentHead;
}
