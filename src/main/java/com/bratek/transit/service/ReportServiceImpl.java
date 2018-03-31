package com.bratek.transit.service;

import com.bratek.transit.model.DailyReport;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ReportServiceImpl implements ReportService{

    @Async
    @Override
    public CompletableFuture<List<DailyReport>> findReports(Date startDate, Date endDate) throws InterruptedException {
        Thread.sleep(10000L);
        return CompletableFuture.completedFuture(Collections.singletonList(new DailyReport(100L, 100.70)));
    }
}
