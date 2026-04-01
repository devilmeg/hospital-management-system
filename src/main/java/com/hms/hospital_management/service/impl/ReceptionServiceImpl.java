package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.repository.query.*;
import com.hms.hospital_management.repository.relation.*;
import com.hms.hospital_management.service.ReceptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReceptionServiceImpl implements ReceptionService {

    private final RoomQueryRepository roomRepository;
    private final AppointmentDateRepository appointmentRepository;
    private final NurseOnCallRepository nurseRepository;

    public ReceptionServiceImpl(RoomQueryRepository roomRepository,
                                AppointmentDateRepository appointmentRepository,
                                NurseOnCallRepository nurseRepository) {
        this.roomRepository = roomRepository;
        this.appointmentRepository = appointmentRepository;
        this.nurseRepository = nurseRepository;
    }

    @Override
    public List<RoomStatusDTO> getRoomStatus() {
        return roomRepository.getRoomStatus();
    }

    @Override
    public List<AppointmentByDateDTO> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.getAppointmentsByDate(date);
    }

    @Override
    public List<NurseOnCallDTO> getOnCallNurses() {
        return nurseRepository.getActiveOnCall();
    }

    @Override
    public List<NurseOnCallDTO> getNurses() {
        return List.of();
    }
}