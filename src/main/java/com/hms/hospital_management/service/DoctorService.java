package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.DoctorAppointmentDTO;
import com.hms.hospital_management.dto.response.DoctorPatientDTO;
import com.hms.hospital_management.dto.response.DoctorPatientHistoryDto;
import com.hms.hospital_management.dto.response.DoctorProcedureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DoctorService {
    /**
     * Fetches ALl Patient for a specific doctor through id
     * Use Case : Viewing Patients and its record for the treatment
     * for all patients of a specific doctor
     * @param id Unique Employee id of a Doctor/Physician
     * @param pageable create a  page of size 2, and divide into pages 10
     * @return  Patients in a page
     */
    Page<DoctorPatientDTO> getPatients(Integer id, Pageable pageable);

    /**
     * Fetches all appointment schedules for today
     * Use Case : Doctor / Physician will schedule day accordingly
     * for a specific doctor/physician
     * @param id Employee id of a specific doctor
     * @param pageable create pages of result and divide into defined pages size
     * @return Pages of  the Doctor Appointment DTO
     */
    Page<DoctorAppointmentDTO> getTodayAppointments(Integer id, Pageable pageable);

    /**
     * Fetches  the training done and its info  by a specific doctor
     * Use Case : To check the status of their certifications
     * @param id Employee id of a particular doctor/physician
     * @param pageable
     * @return
     */
    Page<DoctorProcedureDTO> getTrainedProcedures(Integer id, Pageable pageable);

    /**
     * Fetches List of the doctor's patient history
     * Use Case : To check the procedure and medication
     * followed by a particular patients till now
     * @param ssn patient primary key / id
     * @return List of procedures and medications
     */
    List<DoctorPatientHistoryDto> getPatientMedicalHistory(Integer ssn);

}
