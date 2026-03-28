package com.hms.hospital_management.controller;

import com.hms.hospital_management.dto.response.NurseResponseDto;
import com.hms.hospital_management.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    //  GET API: /api/nurses/on-call
    @GetMapping("/on-call")
    public List<NurseResponseDto> getOnCallNurses() {
        return nurseService.getNursesOnCall();
    }
}