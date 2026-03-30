package com.hms.hospital_management.repository;

import com.hms.hospital_management.entity.On_Call;
import com.hms.hospital_management.entity.On_Call_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OnCallRepository extends JpaRepository<On_Call, On_Call_Id> {

    // current active nurses
//    @Query("SELECT o FROM On_Call o WHERE CURRENT_TIMESTAMP BETWEEN o.id.onCallStart AND o.id.onCallEnd")
    @Query("SELECT o FROM On_Call o")
    List<On_Call> findCurrentlyOnCall();
}