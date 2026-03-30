package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}