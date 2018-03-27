package com.bratek.transit.service;

import com.bratek.transit.model.DailyReport;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<DailyReport> findReports(Date startDate, Date endDate);
}
