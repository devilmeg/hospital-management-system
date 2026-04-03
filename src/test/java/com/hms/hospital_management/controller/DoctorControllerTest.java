package com.hms.hospital_management.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DoctorController.class)
@AutoConfigureMockMvc(addFilters = false) // Disables Security for clean Unit Testing
class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DoctorService doctorService;

    @Autowired
    private ObjectMapper objectMapper;

    // --- SUCCESS CASES ---

    /**
     * testing the get Appointments url
     * Use Cases: Testing the url working in isolated environment
     * @throws Exception  if anything went wrong
     */
    @Test
    void getTodayAppointments_Success() throws Exception {
        Integer id = 3;
        Page<DoctorAppointmentDTO> mockPage = new PageImpl<>(List.of(new DoctorAppointmentDTO()));

        Mockito.when(doctorService.getTodayAppointments(eq(id), any(Pageable.class))).thenReturn(mockPage);

        // URL: /api/v1/doctors/3/appointments/today
        mockMvc.perform(get("/api/v1/doctors/{id}/appointments/today", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }

    /**
     * Testing : Get procedure
     * Controller things :
     * @throws Exception
     */

    @Test
    void getProcedures_Success() throws Exception {
        Integer id = 3;
        Page<DoctorProcedureDTO> mockPage = new PageImpl<>(List.of(new DoctorProcedureDTO()));

        Mockito.when(doctorService.getTrainedProcedures(eq(id), any(Pageable.class))).thenReturn(mockPage);

        // URL: /api/v1/doctors/3/procedures/trained
        mockMvc.perform(get("/api/v1/doctors/{id}/procedures/trained", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }

    /**
     * Testing : patient history url
     * @throws Exception
     */
    @Test
    void showPatientHistory_Success() throws Exception {
        Integer ssn = 12345;
        Mockito.when(doctorService.getPatientMedicalHistory(ssn)).thenReturn(Collections.emptyList());

        // URL: /api/v1/doctors/patients/12345/history (Matching your constant)
        mockMvc.perform(get("/api/v1/doctors/patients/{ssn}/history", ssn))
                .andExpect(status().isOk());
    }

    // --- FAILURE CASES ---

    /**
     * Testing  if we pass some garbage
     * value to the url parameter
     * @throws Exception
     */
    @Test
    void getDoctorPatients_Fail_InvalidIdFormat() throws Exception {
        // USE "abc" instead of "10".
        // This forces Spring to fail before even reaching your service.
        mockMvc.perform(get("/api/v1/doctors/abc/patients"))
                .andExpect(status().isBadRequest());
    }

    /**
     * Testing Fail Server Error for the
     * get Appointment controller
     * @throws Exception
     */

    @Test
    void getTodayAppointments_Fail_ServerError() throws Exception {
        Integer id = 3;
        Mockito.when(doctorService.getTodayAppointments(eq(id), any(Pageable.class)))
                .thenThrow(new RuntimeException("Server Error"));

        mockMvc.perform(get("/api/v1/doctors/{id}/appointments/today", id))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.status").value("FAILED"));
    }

    /**
     * Testing Failing of GetProcedure Controller
     * @throws Exception
     */
    @Test
    void getProcedures_Fail_EmptyResult() throws Exception {
        Integer id = 3;
        Mockito.when(doctorService.getTrainedProcedures(eq(id), any(Pageable.class)))
                .thenReturn(Page.empty());

        mockMvc.perform(get("/api/v1/doctors/{id}/procedures/trained", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("No procedures found"));
    }
}