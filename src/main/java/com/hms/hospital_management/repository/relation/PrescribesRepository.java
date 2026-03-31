package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.entity.Prescribes;
import com.hms.hospital_management.entity.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId> {
}
