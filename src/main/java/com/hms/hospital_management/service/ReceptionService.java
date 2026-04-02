package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.*;

import java.time.LocalDate;
import java.util.List;

public interface ReceptionService {

    List<RoomStatusDTO> getRoomStatus();

    List<AppointmentByDateDTO> getAppointmentsByDate(LocalDate date);

    List<NurseOnCallDTO> getOnCallNurses();
}