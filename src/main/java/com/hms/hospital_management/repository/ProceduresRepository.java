package com.hms.hospital_management.repository;

import com.hms.hospital_management.entity.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresRepository extends JpaRepository<Procedures, Integer> {
}
