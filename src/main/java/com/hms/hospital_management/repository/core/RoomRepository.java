package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Block_Id;
import com.hms.hospital_management.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
