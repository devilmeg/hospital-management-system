package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.core.PatientRepository;
import com.hms.hospital_management.repository.query.*;
import com.hms.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientQueryRepository patientQueryRepository;
    private final AppointmentQueryRepository appointmentRepository;
    private final PrescriptionQueryRepository prescriptionRepository;

    public PatientServiceImpl(PatientRepository patientRepository,
                              PatientQueryRepository patientQueryRepository,
                              AppointmentQueryRepository appointmentRepository,
                              PrescriptionQueryRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.patientQueryRepository = patientQueryRepository;
        this.appointmentRepository = appointmentRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public PatientProfileDTO getPatientProfile(Integer ssn) {
        validatePatient(ssn);
        return patientQueryRepository.getPatientProfile(ssn);
    }

    @Override
    public List<PatientAppointmentDTO> getAppointments(Integer ssn) {
        validatePatient(ssn);
        return appointmentRepository.getAppointments(ssn);
    }

    @Override
    public List<PrescriptionDTO> getPrescriptions(Integer ssn) {
        validatePatient(ssn);
        return prescriptionRepository.getPrescriptions(ssn);
    }

    private void validatePatient(Integer ssn) {
        if (!patientRepository.existsById(ssn)) {
            throw new ResourceNotFoundException("Patient not found: " + ssn);
        }
    }
}