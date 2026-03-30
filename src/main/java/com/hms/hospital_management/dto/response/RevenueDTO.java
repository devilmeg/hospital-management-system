package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueDTO {

    private String procedureName;
    private Long totalPerformed;
    private Double totalRevenue;
}
