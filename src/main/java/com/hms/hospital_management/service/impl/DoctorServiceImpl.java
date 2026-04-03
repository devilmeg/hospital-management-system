package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.entity.Appointment;
import com.hms.hospital_management.entity.Trained_In;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.query.*;
import com.hms.hospital_management.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorQueryRepository doctorRepository;
    private final DoctorAppointmentQueryRepository appointmentRepository;
    private final DoctorProcedureRepository procedureRepository;
    private final DoctorPatientHistoryQueryRepository  patientHistoryQueryRepository;

    public DoctorServiceImpl(DoctorQueryRepository doctorRepository,
                             DoctorAppointmentQueryRepository appointmentRepository,
                             DoctorProcedureRepository procedureRepository,
                             DoctorPatientHistoryQueryRepository patientHistoryQueryRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.procedureRepository = procedureRepository;
        this.patientHistoryQueryRepository = patientHistoryQueryRepository;
    }


    @Override
    public Page<DoctorPatientDTO> getPatients(Integer id, Pageable pageable) {
        Page<DoctorPatientDTO> list = doctorRepository.getDoctorPatients(id, pageable);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No patients found for doctor id: " + id);
        }

        return list;
    }

    @Override
    public Page<DoctorAppointmentDTO> getTodayAppointments(Integer id, Pageable pageable) {
        Page<Appointment> appointments = appointmentRepository.getTodayAppointments(id, pageable);
        return appointments.map(DoctorAppointmentDTO::new);
    }

    @Override
    public Page<DoctorProcedureDTO> getTrainedProcedures(Integer id, Pageable pageable) {

        Page<Trained_In> trainingRecords = procedureRepository.getTrainedProcedures(id,pageable);

        return trainingRecords.map(DoctorProcedureDTO::new);
    }

    @Override
    public List<DoctorPatientHistoryDto> getPatientMedicalHistory(Integer ssn) {
        List<Appointment> appointments = patientHistoryQueryRepository.findAllHistoryByPatientSSN(ssn);

        return appointments.stream()
                .map(DoctorPatientHistoryDto::new)
                .collect(Collectors.toUnmodifiableList());
    }
}