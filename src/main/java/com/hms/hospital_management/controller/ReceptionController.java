package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.*;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.service.ReceptionService;
import com.hms.hospital_management.dto.response.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReceptionController {

    private final ReceptionService receptionService;

    public ReceptionController(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    @GetMapping(ApiPaths.ROOMS + ApiPaths.ROOM_STATUS)
    public ResponseEntity<ApiResponse<List<RoomStatusDTO>>> getRoomStatus() {

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        receptionService.getRoomStatus())
        );
    }

    @GetMapping(ApiPaths.APPOINTMENTS + ApiPaths.APPOINTMENTS_BY_DATE)
    public ResponseEntity<ApiResponse<List<AppointmentByDateDTO>>> getAppointmentsByDate(
            @PathVariable String date) {

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        receptionService.getAppointmentsByDate(LocalDate.parse(date)))
        );
    }
    //nurses on call
    @GetMapping(ApiPaths.NURSES + ApiPaths.NURSES_ON_CALL)
    public ResponseEntity<ApiResponse<List<NurseOnCallDTO>>> getOnCallNurses() {

        return ResponseEntity.ok(
                new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                        receptionService.getOnCallNurses())
        );
    }




}