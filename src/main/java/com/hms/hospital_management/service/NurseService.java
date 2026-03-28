package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.NurseResponseDto;
import com.hms.hospital_management.entity.On_Call;
import com.hms.hospital_management.repository.OnCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    private OnCallRepository onCallRepository;

    public List<NurseResponseDto> getNursesOnCall() {

        List<On_Call> list = onCallRepository.findCurrentlyOnCall();

        return list.stream().map(o -> new NurseResponseDto(
                o.getNurse().getEmployeeId(),
                o.getNurse().getName(),
                o.getBlock().getBlockId().getBlockFloor(),
                o.getBlock().getBlockId().getBlockCode()
        )).toList();
    }
}