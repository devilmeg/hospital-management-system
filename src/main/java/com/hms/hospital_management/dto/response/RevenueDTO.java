package com.hms.hospital_management.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueDTO {

    private String source;      // "Procedure" or "Room"
    private String identifier;  // procedure name OR room number
    private Long count;
    private Double revenue;
    public RevenueDTO(String source, String identifier, Long count, Number revenue) {
        this.source = source;
        this.identifier = identifier;
        this.count = count;
        this.revenue = revenue != null ? revenue.doubleValue() : 0.0;
    }
}
