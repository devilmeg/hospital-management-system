package com.hms.hospital_management.repository.query;

import java.util.List;

public interface PatientQueryRepository {

    List<Object[]> getPatientProfile(Integer ssn);

    List<Object[]> getPatientPrescriptions(Integer ssn);

    List<Object[]> getPatientAppointments(Integer ssn);
}