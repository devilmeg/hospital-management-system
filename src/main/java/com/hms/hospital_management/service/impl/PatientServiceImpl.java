package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.core.PatientRepository;
import com.hms.hospital_management.repository.query.*;
import com.hms.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientQueryRepository patientQueryRepository;
    private final AppointmentQueryRepository appointmentRepository;
    private final PrescriptionQueryRepository prescriptionRepository;
    private final StayQueryRepository stayRepository;

    public PatientServiceImpl(PatientRepository patientRepository,
                              PatientQueryRepository patientQueryRepository,
                              AppointmentQueryRepository appointmentRepository,
                              PrescriptionQueryRepository prescriptionRepository, StayQueryRepository stayRepository) {
        this.patientRepository = patientRepository;
        this.patientQueryRepository = patientQueryRepository;
        this.appointmentRepository = appointmentRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.stayRepository = stayRepository;
    }

    @Override
    public PatientProfileDTO getPatientProfile(Integer ssn) {
        validatePatient(ssn);
        return patientQueryRepository.getPatientProfile(ssn);
    }



    @Override
    public List<PatientPrescriptionDTO> getPatientPrescriptions(Integer ssn) {
        validatePatient(ssn);
        List<PatientPrescriptionDTO> list = patientQueryRepository.getPatientPrescriptions(ssn);
        Date now = new Date();
        for (PatientPrescriptionDTO dto : list) {

            Date prescriptionDate = dto.getAppointmentDate();

            long diff = now.getTime() - prescriptionDate.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            if (days <= 7) {
                dto.setStatus("Active");
            } else {
                dto.setStatus("Completed");
            }
        }

        return list;
    }

    @Override
    public List<PatientAppointmentDTO> getAppointments(Integer ssn) {

        List<PatientAppointmentDTO> list =
                patientQueryRepository.getAppointments(ssn);

        LocalDateTime now = LocalDateTime.now();

        for (PatientAppointmentDTO dto : list) {

            if (dto.getStartTime() == null) continue;

            if (dto.getEndTime() != null && dto.getEndTime().isBefore(now)) {
                dto.setStatus("COMPLETED");
            } else if (dto.getStartTime().isAfter(now)) {
                dto.setStatus("UPCOMING");
            } else {
                dto.setStatus("ONGOING");
            }
        }

        return list;
    }



























    private void validatePatient(Integer ssn) {
        if (!patientRepository.existsById(ssn)) {
            throw new ResourceNotFoundException("Patient not found: " + ssn);
        }
    }

    @Override
    public List<PatientStayHistoryDTO> getStayHistory(Integer ssn) {

        validatePatient(ssn);

        List<PatientStayHistoryDTO> list = stayRepository.getStayHistory(ssn);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No stay history found for patient: " + ssn);
        }

        return list;
    }
}