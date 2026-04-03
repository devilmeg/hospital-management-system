package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.ApiPaths;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.PatientProfileDTO;
import com.hms.hospital_management.dto.response.PatientStayHistoryDTO;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatientController.class, excludeAutoConfiguration = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    void testGetPatientProfile() throws Exception {
        PatientProfileDTO mockProfile = PatientProfileDTO.builder()
                .ssn(12345)
                .name("John Doe")
                .address("123 Main St")
                .phone("555-1234")
                .physicianName("Dr. Smith")
                .build();

        Mockito.when(patientService.getPatientProfile(anyInt())).thenReturn(mockProfile);

        mockMvc.perform(get(ApiPaths.PATIENTS + "/12345")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(AppConstants.SUCCESS))
                .andExpect(jsonPath("$.message").value(AppConstants.DATA_FETCHED))
                .andExpect(jsonPath("$.data.ssn").value(12345))
                .andExpect(jsonPath("$.data.name").value("John Doe"))
                .andExpect(jsonPath("$.data.physicianName").value("Dr. Smith"));
    }

    @Test
    void testGetStayHistory() throws Exception {
        PatientStayHistoryDTO stay1 = PatientStayHistoryDTO.builder()
                .roomNumber(101)
                .roomType("ICU")
                .admittedAt(LocalDateTime.of(2023, 10, 1, 10, 0))
                .dischargedAt(LocalDateTime.of(2023, 10, 5, 12, 0))
                .build();

        PatientStayHistoryDTO stay2 = PatientStayHistoryDTO.builder()
                .roomNumber(205)
                .roomType("General")
                .admittedAt(LocalDateTime.of(2024, 1, 15, 9, 30))
                .dischargedAt(LocalDateTime.of(2024, 1, 20, 14, 0))
                .build();

        List<PatientStayHistoryDTO> mockHistory = Arrays.asList(stay1, stay2);

        Mockito.when(patientService.getStayHistory(anyInt())).thenReturn(mockHistory);

        mockMvc.perform(get(ApiPaths.PATIENTS + "/12345/stay-history")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(AppConstants.SUCCESS))
                .andExpect(jsonPath("$.message").value(AppConstants.DATA_FETCHED))
                .andExpect(jsonPath("$.data.length()").value(2))
                .andExpect(jsonPath("$.data[0].roomNumber").value(101))
                .andExpect(jsonPath("$.data[0].roomType").value("ICU"))
                .andExpect(jsonPath("$.data[1].roomNumber").value(205))
                .andExpect(jsonPath("$.data[1].roomType").value("General"));
    }

    @Test
    void testGetPatientProfile_NotFound() throws Exception {
        Mockito.when(patientService.getPatientProfile(anyInt()))
                .thenThrow(new ResourceNotFoundException("Patient not found with SSN: 99999"));

        mockMvc.perform(get(ApiPaths.PATIENTS + "/99999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(AppConstants.FAILED))
                .andExpect(jsonPath("$.errorMessage").value("Patient not found with SSN: 99999"));
    }

    @Test
    void testGetStayHistory_NotFound() throws Exception {
        Mockito.when(patientService.getStayHistory(anyInt()))
                .thenThrow(new ResourceNotFoundException("Patient not found with SSN: 99999"));

        mockMvc.perform(get(ApiPaths.PATIENTS + "/99999/stay-history")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(AppConstants.FAILED))
                .andExpect(jsonPath("$.errorMessage").value("Patient not found with SSN: 99999"));
    }
}
