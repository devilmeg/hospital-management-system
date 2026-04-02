package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.DoctorAppointmentDTO;
import com.hms.hospital_management.dto.response.DoctorPatientDTO;
import com.hms.hospital_management.dto.response.DoctorProcedureDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {
    List<DoctorPatientDTO> getPatients(Integer id);

    List<DoctorAppointmentDTO> getTodayAppointments(Integer id);

    List<DoctorProcedureDTO> getTrainedProcedures(Integer id);

}
