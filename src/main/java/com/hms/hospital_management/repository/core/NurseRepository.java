package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {


}