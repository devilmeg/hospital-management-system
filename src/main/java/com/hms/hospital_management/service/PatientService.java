package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.*;

import java.util.List;

public interface PatientService {

    PatientProfileDTO getPatientProfile(Integer ssn);

    List<PatientAppointmentDTO> getAppointments(Integer ssn);

    List<PrescriptionDTO> getPrescriptions(Integer ssn);
}