package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.ApiPaths;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.ApiResponse;
import com.hms.hospital_management.dto.response.PaginatedResponse;
import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.ADMIN)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(ApiPaths.REPORTS + ApiPaths.REVENUE)
    public ResponseEntity<PaginatedResponse<List<RevenueDTO>>> getRevenue(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(adminService.getRevenue(page, size));
    }
//Pagination concept used here
    @GetMapping(ApiPaths.STAFF + ApiPaths.STAFF_ALL)
    public ResponseEntity<PaginatedResponse<List<StaffDTO>>> getAllStaff(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(adminService.getAllStaff(page, size));
    }
}