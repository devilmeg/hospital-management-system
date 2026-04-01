package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.core.PatientRepository;
import com.hms.hospital_management.repository.query.*;
import com.hms.hospital_management.service.DoctorService;
import com.hms.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorQueryRepository doctorRepository;
    private final DoctorAppointmentQueryRepository appointmentRepository;
    private final DoctorProcedureRepository procedureRepository;

    public DoctorServiceImpl(DoctorQueryRepository doctorRepository,
                             DoctorAppointmentQueryRepository appointmentRepository,
                             DoctorProcedureRepository procedureRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.procedureRepository = procedureRepository;
    }

    @Override
    public List<DoctorPatientDTO> getPatients(Integer id) {

        List<DoctorPatientDTO> list = doctorRepository.getDoctorPatients(id);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No patients found for doctor id: " + id);
        }

        return list;
    }
    @Override
    public List<DoctorAppointmentDTO> getTodayAppointments(Integer id) {
        return appointmentRepository.getTodayAppointments(id);
    }

    @Override
    public List<DoctorProcedureDTO> getTrainedProcedures(Integer id) {

        List<DoctorProcedureDTO> list = procedureRepository.getTrainedProcedures(id);



        return list;
    }
}