package com.hms.hospital_management.service.impl;

import com.hms.hospital_management.constants.AppConstants;
import com.hms.hospital_management.dto.response.*;
import com.hms.hospital_management.exception.BadRequestException;
import com.hms.hospital_management.exception.ResourceNotFoundException;
import com.hms.hospital_management.repository.analytics.NurseStaffRepository;
import com.hms.hospital_management.repository.analytics.RevenueRepository;
import com.hms.hospital_management.repository.analytics.StaffRepository;
import com.hms.hospital_management.repository.analytics.StayAnalyticsRepository;
import com.hms.hospital_management.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
    private static final String LOG_FILE = "logs/application.log";

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

        //  Procedure enrichment
        for (RevenueDTO r : procedures) {
            double unit = r.getRevenue() / r.getCount();
            r.setUnitCost(unit);
            r.setTotalDays(null); // removed in response
            r.setCategory("Medical Procedure");
        }

        //  Room enrichment
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

    @Override
    public PaginatedResponse<List<LogDTO>> getLogs(int page, int size, String level) {

        List<LogDTO> allLogs = new ArrayList<>();

        try {
            Path path = Paths.get(System.getProperty("user.dir"), "logs", "hospital-management.log");

            // 🔥 DEBUG PRINT
            System.out.println("LOG FILE PATH: " + path.toAbsolutePath());

            if (!Files.exists(path)) {
                // ❗ DO NOT THROW EXCEPTION
                return PaginatedResponse.<List<LogDTO>>builder()
                        .status("SUCCESS")
                        .message("Log file not found")
                        .currentPage(page)
                        .totalPages(0)
                        .totalRecords((long)0)
                        .data(new ArrayList<>())
                        .build();
            }

            List<String> lines = Files.readAllLines(path);

            // ... existing code in getLogs loop ...
            for (String line : lines) {

                if (line == null || line.length() < 20) continue;

                String time = line.substring(0, 19);
                String remaining = line.substring(20);

                String logLevel = "INFO";
                if (remaining.contains("ERROR")) logLevel = "ERROR";
                else if (remaining.contains("WARN")) logLevel = "WARN";
                else if (remaining.contains("DEBUG")) logLevel = "DEBUG";

                if (level != null && !level.isEmpty() && !logLevel.equals(level)) {
                    continue;
                }

                // --- NEW MINIMIZATION LOGIC START ---
                String displayMessage = remaining;

                // Minimize Spring Boot/System startup noise
                if (remaining.contains("Running with Spring Boot")) {
                    displayMessage = remaining.split("-")[0].trim() + " - [Spring Boot System Info]";
                } else if (remaining.contains("Starting AdminControllerTest")) {
                    displayMessage = remaining.split("-")[0].trim() + " - [Test Started]";
                }
                // --- NEW MINIMIZATION LOGIC END ---

                allLogs.add(new LogDTO(time, logLevel, displayMessage));
            }
// ... existing pagination code ...

        } catch (Exception e) {
            // ❌ REMOVE CRASH
            System.out.println("LOG ERROR: " + e.getMessage());

            return PaginatedResponse.<List<LogDTO>>builder()
                    .status("FAILED")
                    .message("Unable to read logs")
                    .currentPage(page)
                    .totalPages(0)
                    .totalRecords((long)0)
                    .data(new ArrayList<>())
                    .build();
        }

        // ✅ PAGINATION
        int totalRecords = allLogs.size();
        int totalPages = (int) Math.ceil((double) totalRecords / size);

        int start = page * size;
        int end = Math.min(start + size, totalRecords);

        List<LogDTO> pageList = new ArrayList<>();

        if (start < totalRecords) {
            pageList = allLogs.subList(start, end);
        }

        return PaginatedResponse.<List<LogDTO>>builder()
                .status("SUCCESS")
                .message("Logs fetched successfully")
                .currentPage(page)
                .totalPages(totalPages)
                .totalRecords((long)totalRecords)
                .data(pageList)
                .build();
    }


}