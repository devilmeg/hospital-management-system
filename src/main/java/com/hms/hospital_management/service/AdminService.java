package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.PaginatedResponse;
import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;

import java.util.List;

public interface AdminService {


    PaginatedResponse<List<RevenueDTO>> getRevenue(int page, int size);


PaginatedResponse<List<StaffDTO>> getAllStaff(int page, int size);
}