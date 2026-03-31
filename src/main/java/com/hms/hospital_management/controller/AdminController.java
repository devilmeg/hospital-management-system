package com.hms.hospital_management.controller;

import com.hms.hospital_management.constants.ApiPaths;
import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.ApiResponse;
import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class AdminController {
    @RestController
    @RequestMapping(ApiPaths.ADMIN)
    public static class AdminController {

        private final AdminService adminService;

        public AdminController(AdminService adminService) {
            this.adminService = adminService;
        }

        @GetMapping(ApiPaths.REPORTS + ApiPaths.REVENUE)
        public ResponseEntity<ApiResponse<List<RevenueDTO>>> getRevenue() {

            return ResponseEntity.ok(
                    new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                            adminService.getRevenue())
            );
        }

        @GetMapping(ApiPaths.STAFF + ApiPaths.STAFF_ALL)
        public ResponseEntity<ApiResponse<List<StaffDTO>>> getAllStaff() {

            return ResponseEntity.ok(
                    new ApiResponse<>(AppConstants.SUCCESS, AppConstants.DATA_FETCHED,
                            adminService.getAllStaff())
            );
        }
    }
}
