package com.hms.hospital_management.service;

import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;

import java.util.List;

public interface AdminService {

    List<RevenueDTO> getRevenue();

    List<StaffDTO> getAllStaff();
}