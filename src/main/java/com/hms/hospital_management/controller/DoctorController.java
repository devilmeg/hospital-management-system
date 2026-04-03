package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.ApiPaths;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.repository.query.DoctorPatientHistoryQueryRepository;
import com.hms.hospital_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.PHYSICIANS)
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * Retrieves a paginated list of patients associated with a specific physician.
     *
     * @param id       the employee ID of the doctor/physician
     * @param page     the zero-based page index to retrieve
     * @param size     the number of records per page
     * @return a {@link ResponseEntity} containing a {@link Page} of {@link DoctorPatientDTO}
     * and a success metadata response
     */
    @GetMapping(ApiPaths.DOCTOR_PATIENTS)
    public ResponseEntity<ApiResponse<Page<DoctorPatientDTO>>> getDoctorPatients(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<DoctorPatientDTO> patientPage = doctorService.getPatients(id, pageable);
        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED, patientPage)
        );
    }

    /**
     * Retrieves a paginated List of appointment associated with a doctor
     *
     * @param id    the employee ID of the doctor/physician
     * @param page  the zero-based index to retrieve
     * @param size  the number of records per page
     * @return  a {@link ResponseEntity} containing a {@link Page} of {@link DoctorAppointmentDTO}
     */
    @GetMapping(ApiPaths.DOCTOR_APPOINTMENTS_TODAY)
    public ResponseEntity<ApiResponse<Page<DoctorAppointmentDTO>>> getTodayAppointments(@PathVariable Integer id
                                                    , @RequestParam(defaultValue = "0")  int page
                                                    ,@RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<DoctorAppointmentDTO>  result =   doctorService.getTodayAppointments(id,pageable);

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        result)
        );
    }

    /**
     * Retrieves the paginated List of the Training that a doctor has completed
     *
     * @param id    the employee ID of the doctor/physician
     * @param page  the zero based indexing of retrieval
     * @param size  the number of records per page
     * @return      a {@link ResponseEntity} contains {@link Page} of {@link DoctorProcedureDTO}
     */
    @GetMapping(ApiPaths.DOCTOR_PROCEDURES)
    public ResponseEntity<ApiResponse<Page<DoctorProcedureDTO>>> getProcedures(@PathVariable Integer id
                                                            ,@RequestParam(defaultValue = "0") int page
                                                            , @RequestParam(defaultValue = "2") int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<DoctorProcedureDTO> data = doctorService.getTrainedProcedures(id, pageable);

        String message = data.isEmpty()
                ? "No procedures found"
                : AppConstants.DATA_FETCHED;

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, message, data)
        );
    }

    /**
     * Retrieves the list of the procedure done on a specific patients
     *
     * @param ssn   The patient number
     * @return      a {@link ResponseEntity} containing {@link List } of {@link DoctorPatientHistoryDto}
     */

    @GetMapping(ApiPaths.DOCTOR_PATIENTS_RECORD)
    public ResponseEntity<ApiResponse<List<DoctorPatientHistoryDto>>> showPatientHistory(@PathVariable("ssn") Integer ssn) {
        List<DoctorPatientHistoryDto> history = doctorService.getPatientMedicalHistory(ssn);

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS," ",history)
        );
    }

}