package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.*;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.service.PatientService;
import com.hms.hospital_management.dto.response.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.PATIENTS)
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //  GET Patient Profile
    @GetMapping("/{ssn}")
    public ResponseEntity<ApiResponse<PatientProfileDTO>> getPatientProfile(@PathVariable Integer ssn) {

        PatientProfileDTO data = patientService.getPatientProfile(ssn);

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED, data)
        );
    }

    //  GET Appointments
    @GetMapping(ApiPaths.PATIENT_PRESCRIPTIONS)
    public ResponseEntity<ApiResponse<List<PatientPrescriptionDTO>>> getPrescriptions(
            @PathVariable Integer ssn) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        AppConstants.SUCCESS,
                        AppConstants.DATA_FETCHED,
                        patientService.getPatientPrescriptions(ssn)
                )
        );
    }

    // Get Patient Room History
    @GetMapping("/{ssn}/stay-history")
    public ResponseEntity<ApiResponse<List<PatientStayHistoryDTO>>> getStayHistory(
            @PathVariable Integer ssn) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        AppConstants.SUCCESS,
                        AppConstants.DATA_FETCHED,
                        patientService.getStayHistory(ssn)
                )
        );
    }

    @GetMapping("/{ssn}/appointments")
    public ResponseEntity<ApiResponse<List<PatientAppointmentDTO>>> getAppointments(
            @PathVariable Integer ssn) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "SUCCESS",
                        "Appointments fetched",
                        patientService.getAppointments(ssn)
                )
        );
    }
}