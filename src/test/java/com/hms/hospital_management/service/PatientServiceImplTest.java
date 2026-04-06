package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.PatientAppointmentDTO;
import com.hms.hospital_management.dto.response.PatientPrescriptionDTO;
import com.hms.hospital_management.repository.core.PatientRepository;
import com.hms.hospital_management.repository.query.AppointmentQueryRepository;
import com.hms.hospital_management.repository.query.PatientQueryRepository;
import com.hms.hospital_management.repository.query.PrescriptionQueryRepository;
import com.hms.hospital_management.repository.query.StayQueryRepository;
import com.hms.hospital_management.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientQueryRepository patientQueryRepository;

    @Mock
    private AppointmentQueryRepository appointmentRepository;

    @Mock
    private PrescriptionQueryRepository prescriptionRepository;

    @Mock
    private StayQueryRepository stayRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // ================= APPOINTMENTS =================

    @Test
    void getAppointments_shouldReturnList_withStatus() {

        Integer ssn = 1;

        List<PatientAppointmentDTO> mockList = List.of(
                new PatientAppointmentDTO(
                        LocalDateTime.now().minusHours(2),
                        LocalDateTime.now().minusHours(1),
                        "Dr A",
                        null
                ),
                new PatientAppointmentDTO(
                        LocalDateTime.now().plusHours(2),
                        LocalDateTime.now().plusHours(3),
                        "Dr B",
                        null
                )
        );

        when(patientQueryRepository.getAppointments(ssn)).thenReturn(mockList);

        List<PatientAppointmentDTO> result = patientService.getAppointments(ssn);

        assertEquals("COMPLETED", result.get(0).getStatus());
        assertEquals("UPCOMING", result.get(1).getStatus());
    }

    @Test
    void getAppointments_shouldReturnEmptyList() {

        Integer ssn = 1;

        when(patientQueryRepository.getAppointments(ssn)).thenReturn(Collections.emptyList());

        List<PatientAppointmentDTO> result = patientService.getAppointments(ssn);

        assertTrue(result.isEmpty());
    }

    // ================= PRESCRIPTIONS =================

    @Test
    void getPatientPrescriptions_shouldSetStatusCorrectly() {

        Integer ssn = 1;

        when(patientRepository.existsById(ssn)).thenReturn(true);

        Date recentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -10);
        Date oldDate = cal.getTime();

        List<PatientPrescriptionDTO> mockList = List.of(
                new PatientPrescriptionDTO("Med1", "Dose1", "Dr A", recentDate),
                new PatientPrescriptionDTO("Med2", "Dose2", "Dr B", oldDate)
        );

        when(patientQueryRepository.getPatientPrescriptions(ssn)).thenReturn(mockList);

        List<PatientPrescriptionDTO> result =
                patientService.getPatientPrescriptions(ssn);

        assertEquals("Active", result.get(0).getStatus());
        assertEquals("Completed", result.get(1).getStatus());
    }

    @Test
    void getPatientPrescriptions_shouldThrowException_whenPatientNotFound() {

        Integer ssn = 1;

        when(patientRepository.existsById(ssn)).thenReturn(false);

        assertThrows(RuntimeException.class, () ->
                patientService.getPatientPrescriptions(ssn)
        );
    }
}