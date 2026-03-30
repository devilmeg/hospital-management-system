package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.entity.Trained_In;
import com.hms.hospital_management.entity.Trained_InId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainedInRepository extends JpaRepository<Trained_In, Trained_InId> {
}
