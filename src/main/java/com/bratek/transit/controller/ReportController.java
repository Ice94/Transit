package com.bratek.transit.controller;

import com.bratek.transit.model.DailyReport;
import com.bratek.transit.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "/daily")
    public ResponseEntity<List<DailyReport>> getDailyReports(
            @PathParam("startDate") @DateTimeFormat(pattern = "YYYY-MM-DD") Date startDate,
            @PathParam("endDate") @DateTimeFormat(pattern = "YYYY-MM-DD") Date endDate) {
        return new ResponseEntity<>(reportService.findReports(startDate, endDate), HttpStatus.OK);
    }
}
