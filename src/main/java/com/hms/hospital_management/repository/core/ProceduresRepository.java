package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.hms.hospital_management.entity.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProceduresRepository extends JpaRepository<Procedures, Integer> {
    // Find by procedure name
    List<Procedures> findByName(String name);

    // Find procedures with cost greater than
    List<Procedures> findByCostGreaterThan(double cost);

    // Find procedures with cost less than
    List<Procedures> findByCostLessThan(double cost);
}
