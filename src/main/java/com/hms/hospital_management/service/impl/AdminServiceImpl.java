package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.ApiResponse;
import com.hms.hospital_management.dto.response.PaginatedResponse;
import com.hms.hospital_management.dto.response.RevenueDTO;
import com.hms.hospital_management.dto.response.StaffDTO;
import com.hms.hospital_management.exception.BadRequestException;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.analytics.NurseStaffRepository;
import com.hms.hospital_management.repository.analytics.RevenueRepository;
import com.hms.hospital_management.repository.analytics.StaffRepository;
import com.hms.hospital_management.repository.analytics.StayAnalyticsRepository;
import com.hms.hospital_management.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

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
    public PaginatedResponse<List<RevenueDTO>> getRevenue(int page, int size) {

        log.info("Fetching revenue | page={} size={}", page, size);

        if (size <= 0) {
            throw new BadRequestException("Page size must be greater than 0");
        }

        List<RevenueDTO> procedures = revenueRepository.getProcedureRevenue();
        List<RevenueDTO> rooms = stayRepository.getRoomRevenue();

        // ✅ Procedure enrichment
        for (RevenueDTO r : procedures) {
            double unit = r.getRevenue() / r.getCount();
            r.setUnitCost(unit);
            r.setTotalDays(null); // removed in response
            r.setCategory("Medical Procedure");
        }

        // ✅ Room enrichment
        for (RevenueDTO r : rooms) {
            double days = r.getRevenue();
            r.setTotalDays(days);
            r.setUnitCost(1000.0);
            r.setRevenue(days * 1000);
            r.setCategory("Room Stay");
        }

        List<RevenueDTO> all = new ArrayList<>();
        all.addAll(procedures);
        all.addAll(rooms);

        if (all.isEmpty()) {
            throw new ResourceNotFoundException("No revenue data found");
        }

        int totalRecords = all.size();
        int totalPages = (int) Math.ceil((double) totalRecords / size);

        int start = page * size;

        if (start >= totalRecords) {
            throw new ResourceNotFoundException("No data found for requested page");
        }

        int end = Math.min(start + size, totalRecords);

        List<RevenueDTO> paginated = all.subList(start, end);

        log.info("Returning {} revenue records out of {}", paginated.size(), totalRecords);

        return PaginatedResponse.<List<RevenueDTO>>builder()
                .status(AppConstants.SUCCESS)
                .message(AppConstants.DATA_FETCHED)
                .currentPage(page)
                .totalPages(totalPages)
                .totalRecords((long) totalRecords)
                .data(paginated)
                .build();
    }

//    @Override
//    public List<StaffDTO> getAllStaff() {
//
//        List<StaffDTO> list = new ArrayList<>();
//
//        list.addAll(staffRepository.getPhysicians());
//        list.addAll(nurseRepository.getNurses());
//
//        return list;
//    }


    @Override
    public PaginatedResponse<List<StaffDTO>> getAllStaff(int page, int size) {

        log.info("Fetching staff | page={} size={}", page, size);

        //  Validation check
        if (size <= 0) {
            log.error("Invalid page size: {}", size);
            throw new BadRequestException("Page size must be greater than 0");
        }

        if (page < 0) {
            log.error("Invalid page number: {}", page);
            throw new BadRequestException("Page number cannot be negative");
        }

        List<StaffDTO> doctors = staffRepository.getPhysicians();
        List<StaffDTO> nurses = nurseRepository.getNurses();

        List<StaffDTO> all = new ArrayList<>();
        all.addAll(doctors);
        all.addAll(nurses);

        if (all.isEmpty()) {
            log.warn("No staff data found");
            throw new ResourceNotFoundException("No staff data found");
        }

        int totalRecords = all.size();
        int totalPages = (int) Math.ceil((double) totalRecords / size);

        int start = page * size;

        if (start >= totalRecords) {
            log.warn("Page {} exceeds available data", page);
            throw new ResourceNotFoundException("No data found for requested page");
        }

        int end = Math.min(start + size, totalRecords);

        List<StaffDTO> paginated = all.subList(start, end);

        log.info("Returning {} records out of {}", paginated.size(), totalRecords);

        return PaginatedResponse.<List<StaffDTO>>builder()
                .status(AppConstants.SUCCESS)
                .message(AppConstants.DATA_FETCHED)
                .currentPage(page)
                .totalPages(totalPages)
                .totalRecords((long) totalRecords)
                .data(paginated)
                .build();
    }
}