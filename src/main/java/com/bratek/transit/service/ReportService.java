package com.bratek.transit.service;

import com.bratek.transit.model.DailyReport;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ReportService {
    CompletableFuture<List<DailyReport>> findReports(Date startDate, Date endDate) throws InterruptedException;
}
