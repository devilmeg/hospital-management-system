package com.hms.hospital_management.utils;

import com.hms.hospital_management.dto.response.*;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper Utility for converting Object[] → DTO
 * Keeps Service layer clean and reusable
 */
@UtilityClass
public class MapperUtil {

    // ==============================
    // 🧠 PATIENT MAPPERS
    // ==============================

    public static PatientProfileDTO mapToPatientProfile(Object[] row) {
        return PatientProfileDTO.builder()
                .name((String) row[0])
                .address((String) row[1])
                .phone((String) row[2])
                .primaryDoctor((String) row[3])
                .build();
    }

    public static PrescriptionDTO mapToPrescription(Object[] row) {
        return PrescriptionDTO.builder()
                .medicationName((String) row[0])
                .prescribedDate(String.valueOf(row[1]))
                .doctorName((String) row[2])
                .build();
    }

    public static AppointmentDTO mapToPatientAppointment(Object[] row) {
        return AppointmentDTO.builder()
                .appointmentId((Integer) row[0])
                .appointmentTime(String.valueOf(row[1]))
                .doctorName((String) row[2])
                .build();
    }

    // ==============================
    // 🧠 PHYSICIAN MAPPERS
    // ==============================

    public static DoctorPatientDTO mapToDoctorPatient(Object[] row) {
        return DoctorPatientDTO.builder()
                .patientName((String) row[0])
                .build();
    }

    public static DoctorAppointmentDTO mapToDoctorAppointment(Object[] row) {
        return DoctorAppointmentDTO.builder()
                .patientName((String) row[0])
                .roomNumber((Integer) row[1])
                .appointmentTime(String.valueOf(row[2]))
                .build();
    }

    public static DoctorProcedureDTO mapToDoctorProcedure(Object[] row) {
        return DoctorProcedureDTO.builder()
                .procedureName((String) row[0])
                .build();
    }

    // ==============================
    // 🧠 RECEPTION MAPPERS
    // ==============================

    public static RoomStatusDTO mapToRoomStatus(Object[] row) {
        return RoomStatusDTO.builder()
                .roomNumber((Integer) row[0])
                .unavailable((Boolean) row[1])
                .floor((Integer) row[2])
                .build();
    }

    public static AppointmentByDateDTO mapToAppointmentByDate(Object[] row) {
        return AppointmentByDateDTO.builder()
                .appointmentId((Integer) row[0])
                .patientName((String) row[1])
                .doctorName((String) row[2])
                .build();
    }

    public static OnCallNurseDTO mapToOnCallNurse(Object[] row) {
        return OnCallNurseDTO.builder()
                .nurseName((String) row[0])
                .floor((Integer) row[1])
                .build();
    }

    // ==============================
    // 🧠 ADMIN MAPPERS
    // ==============================

    public static RevenueDTO mapToRevenue(Object[] row) {
        return RevenueDTO.builder()
                .procedureName((String) row[0])
                .totalPerformed(((Number) row[1]).longValue())
                .totalRevenue(((Number) row[2]).doubleValue())
                .build();
    }

    public static StaffDTO mapToStaff(Object[] row) {
        return StaffDTO.builder()
                .name((String) row[0])
                .role((String) row[1])
                .department(row[2] != null ? (String) row[2] : "N/A")
                .build();
    }

    // ==============================
    // 🔁 LIST MAPPERS (IMPORTANT)
    // ==============================

    public static <T> List<T> mapList(List<Object[]> rows, java.util.function.Function<Object[], T> mapper) {
        return rows.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}