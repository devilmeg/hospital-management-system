package com.hms.hospital_management.repository.core;

import com.hms.hospital_management.entity.Block;
import com.hms.hospital_management.entity.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, BlockId> {
    // find by floor
    List<Block> findByIdBlockFloor(int blockFloor);

    // find by code
    List<Block> findByIdBlockCode(int blockCode);
}