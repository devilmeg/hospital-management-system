package com.hms.hospital_management.repository;

import com.hms.hospital_management.entity.Trained_InId;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hms.hospital_management.entity.Trained_In;
import org.springframework.stereotype.Repository;

@Repository
public interface Trained_InRepository extends JpaRepository<Trained_In, Trained_InId> {
}
