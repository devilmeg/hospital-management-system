package com.hms.hospital_management.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // hide null fields
public class RevenueDTO {

    private String source;
    private String identifier;
    private Long count;

    private Double unitCost;
    private Double totalDays; // only for Room
    private Double revenue;

    private String category;

    // Constructor used by JPQL in  this way
    public RevenueDTO(String source, String identifier, Long count, Number revenue) {
        this.source = source;
        this.identifier = identifier;
        this.count = count;
        this.revenue = revenue != null ? revenue.doubleValue() : 0.0;
    }
}