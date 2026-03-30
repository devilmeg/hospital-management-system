package com.hms.hospital_management.repository.query;


import java.util.List;

public interface PhysicianQueryRepository {

    List<Object[]> getDoctorPatients(Integer doctorId);

    List<Object[]> getTodayAppointments(Integer doctorId);

    List<Object[]> getDoctorProcedures(Integer doctorId);
}
