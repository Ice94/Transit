package com.bratek.transit.service;

import com.bratek.transit.model.DailyReport;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Override
    public List<DailyReport> findReports(Date startDate, Date endDate) {
        return Collections.singletonList(new DailyReport(100L, 100.70));
    }
}
