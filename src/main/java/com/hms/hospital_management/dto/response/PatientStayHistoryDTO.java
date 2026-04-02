package com.hms.hospital_management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientStayHistoryDTO {

    private Integer roomNumber;
    private String roomType;
    private LocalDateTime admittedAt;
    private LocalDateTime dischargedAt;
}