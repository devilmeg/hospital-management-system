package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.ApiPaths;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.ApiResponse;
import com.hms.hospital_management.dto.response.DoctorAppointmentDTO;
import com.hms.hospital_management.dto.response.DoctorPatientDTO;
import com.hms.hospital_management.dto.response.DoctorProcedureDTO;
import com.hms.hospital_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.PHYSICIANS)
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(ApiPaths.DOCTOR_PATIENTS)
    public ResponseEntity<ApiResponse<List<DoctorPatientDTO>>> getDoctorPatients(@PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        doctorService.getPatients(id))
        );
    }

    @GetMapping(ApiPaths.DOCTOR_APPOINTMENTS_TODAY)
    public ResponseEntity<ApiResponse<List<DoctorAppointmentDTO>>> getTodayAppointments(@PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        doctorService.getTodayAppointments(id))
        );
    }

    @GetMapping(ApiPaths.DOCTOR_PROCEDURES)
    public ResponseEntity<ApiResponse<List<DoctorProcedureDTO>>> getProcedures(@PathVariable Integer id) {

        List<DoctorProcedureDTO> data = doctorService.getTrainedProcedures(id);

        String message = data.isEmpty()
                ? "No procedures found"
                : AppConstants.DATA_FETCHED;

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, message, data)
        );
    }
}