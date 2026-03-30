package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.entity.Undergoes;
import com.hms.hospital_management.entity.UndergoesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UndergoesRepository extends JpaRepository<Undergoes, UndergoesId> {
}