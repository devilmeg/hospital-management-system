package com.hms.hospital_management.dto.response;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDTO {

    private String time;
    private String level;
    private String message;
}
