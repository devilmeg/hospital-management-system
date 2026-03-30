package com.hms.hospital_management.repository.analytics;

import java.util.List;

public interface ReportRepository {
    List<Object[]> getRevenueReport();
}