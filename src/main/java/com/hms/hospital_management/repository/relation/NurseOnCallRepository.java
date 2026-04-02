package com.hms.hospital_management.repository.relation;

import com.hms.hospital_management.dto.response.NurseOnCallDTO;
import com.hms.hospital_management.entity.On_Call;
import com.hms.hospital_management.entity.On_Call_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseOnCallRepository extends JpaRepository<On_Call, On_Call_Id> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.NurseOnCallDTO(
            n.name,
            b.id.blockFloor,
            b.id.blockCode,
            o.id.onCallStart,
            o.id.onCallEnd
            
        )
        FROM On_Call o
        JOIN o.nurse n
        JOIN o.block b
       
    """)
    List<NurseOnCallDTO> getActiveOnCall();
}