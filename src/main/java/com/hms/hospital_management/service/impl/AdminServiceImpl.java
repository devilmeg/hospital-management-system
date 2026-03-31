package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.repository.analytics.NurseStaffRepository;
import com.hms.hospital_management.repository.analytics.RevenueRepository;
import com.hms.hospital_management.repository.analytics.StaffRepository;
import com.hms.hospital_management.repository.analytics.StayAnalyticsRepository;
import com.hms.hospital_management.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final RevenueRepository revenueRepository;
    private final StayAnalyticsRepository stayRepository;
    private final StaffRepository staffRepository;
    private final NurseStaffRepository nurseRepository;

    public AdminServiceImpl(RevenueRepository revenueRepository,
                            StayAnalyticsRepository stayRepository,
                            StaffRepository staffRepository,
                            NurseStaffRepository nurseRepository) {
        this.revenueRepository = revenueRepository;
        this.stayRepository = stayRepository;
        this.staffRepository = staffRepository;
        this.nurseRepository = nurseRepository;
    }

    @Override
    public List<RevenueDTO> getRevenue() {

        List<RevenueDTO> result = new ArrayList<>();


        result.addAll(revenueRepository.getProcedureRevenue());


        List<RevenueDTO> roomList = stayRepository.getRoomRevenue();

        for (RevenueDTO r : roomList) {
            if (r.getRevenue() != null) {
                r.setRevenue(r.getRevenue() * 1000); // cost per day
            }
        }

        result.addAll(roomList);

        return result;
    }

    @Override
    public List<StaffDTO> getAllStaff() {

        List<StaffDTO> list = new ArrayList<>();

        list.addAll(staffRepository.getPhysicians());
        list.addAll(nurseRepository.getNurses());

        return list;
    }
}