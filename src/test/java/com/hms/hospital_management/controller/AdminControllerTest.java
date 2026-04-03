package com.hms.hospital_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.exception.BadRequestException;
import com.hms.hospital_management.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;


    // POSITIVE TEST: GET REVENUE

    @Test
    void shouldReturnRevenueData() throws Exception {

        RevenueDTO dto = RevenueDTO.builder()
                .source("Procedure")
                .identifier("Test Procedure")
                .count(2L)
                .unitCost(1000.0)
                .revenue(2000.0)
                .category("Medical Procedure")
                .build();

        PaginatedResponse<List<RevenueDTO>> response =
                PaginatedResponse.<List<RevenueDTO>>builder()
                        .status("SUCCESS")
                        .message("Data fetched successfully")
                        .currentPage(0)
                        .totalPages(1)
                        .totalRecords(1L)
                        .data(List.of(dto))
                        .build();

        Mockito.when(adminService.getRevenue(anyInt(), anyInt()))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/admin/reports/revenue")
                        .param("page", "0")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].identifier").value("Test Procedure"));
    }


    //  NEGATIVE TEST: INVALID PAGE SIZE

    @Test
    void shouldReturnBadRequestForInvalidSize() throws Exception {

        Mockito.when(adminService.getRevenue(anyInt(), eq(0)))
                .thenThrow(new BadRequestException("Page size must be greater than 0"));

        mockMvc.perform(get("/api/v1/admin/reports/revenue")
                        .param("page", "0")
                        .param("size", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.errorMessage").value("Page size must be greater than 0"));
    }


    // NEGATIVE TEST: NO DATA FOUND

    @Test
    void shouldReturnNotFoundWhenNoRevenueData() throws Exception {

        Mockito.when(adminService.getRevenue(anyInt(), anyInt()))
                .thenThrow(new RuntimeException("No revenue data found"));

        mockMvc.perform(get("/api/v1/admin/reports/revenue"))
                .andExpect(status().isBadRequest())
                .andExpect(status().isNotFound());
    }


    // POSITIVE TEST: GET STAFF

    @Test
    void shouldReturnStaffData() throws Exception {

        StaffDTO staff = StaffDTO.builder()
                .name("John")
                .role("Physician")
                .position("Doctor")
                .departmentName("General")
                .primaryAffiliation(true)
                .isDepartmentHead(false)
                .build();

        PaginatedResponse<List<StaffDTO>> response =
                PaginatedResponse.<List<StaffDTO>>builder()
                        .status("SUCCESS")
                        .message("Data fetched successfully")
                        .currentPage(0)
                        .totalPages(1)
                        .totalRecords(1L)
                        .data(List.of(staff))
                        .build();

        Mockito.when(adminService.getAllStaff(anyInt(), anyInt()))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/admin/staff/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value("John"))
                .andExpect(jsonPath("$.data[0].role").value("Physician"));
    }


    //  NEGATIVE TEST: NO STAFF FOUND
    @Test
    void shouldReturnErrorWhenNoStaffData() throws Exception {

        Mockito.when(adminService.getAllStaff(anyInt(), anyInt()))
                .thenThrow(new RuntimeException("No staff data found"));

        mockMvc.perform(get("/api/v1/admin/staff/all"))
                .andExpect(status().isInternalServerError());
    }
}