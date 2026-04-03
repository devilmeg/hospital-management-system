package com.hms.hospital_management.dto.response;



import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedResponse<T> {

    private String status;
    private String message;

    private Integer currentPage;
    private Integer totalPages;
    private Long totalRecords;

    private T data;
}
