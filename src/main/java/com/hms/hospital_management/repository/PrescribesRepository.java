package com.hms.hospital_management.repository;

import com.hms.hospital_management.entity.Prescribes;
import com.hms.hospital_management.entity.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId> {
}
