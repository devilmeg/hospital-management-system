package com.hms.hospital_management.repository.query;

import java.time.LocalDate;
import java.util.List;

public interface ReceptionQueryRepository {

    List<Object[]> getRoomStatus();

    List<Object[]> getAppointmentsByDate(LocalDate date);

    List<Object[]> getOnCallNurses();
}