package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.entity.On_Call_Id;
import com.hms.hospital_management.entity.On_Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnCallRepository extends JpaRepository<On_Call, On_Call_Id> {
}
