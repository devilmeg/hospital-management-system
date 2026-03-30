package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Patient;
import com.hms.hospital_management.entity.Room;
import com.hms.hospital_management.entity.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer> {

    // Find stays for a patient
    List<Stay> findByPatient(Patient patient);

    // Find stays for a room
    List<Stay> findByRoom(Room room);

    // IMPORTANT - active patients
    List<Stay> findByStayEndAfter(LocalDateTime currentTime);

    // Date range query
    List<Stay> findByStayStartBetween(LocalDateTime start, LocalDateTime end);
}