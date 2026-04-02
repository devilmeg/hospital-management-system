package com.hms.hospital_management.repository.query;

import com.hms.hospital_management.dto.response.RoomStatusDTO;
import com.hms.hospital_management.entity.Room;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface RoomQueryRepository extends JpaRepository<Room, Integer> {

    @Query("""
        SELECT new com.hms.hospital_management.dto.response.RoomStatusDTO(
            r.roomNumber,
            r.unavailable
        )
        FROM Room r
    """)
    List<RoomStatusDTO> getRoomStatus();
}