package org.library.rest.controller;


import org.library.rest.request.AuthRequest;
import org.library.rest.response.AuthResponse;
import org.library.rest.response.SalesReportResponse;
import org.library.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    SalesReportService salesReportService;

    @GetMapping
    public ResponseEntity<SalesReportResponse> salesReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return ResponseEntity.ok(salesReportService.generateSalesReport(startDate, endDate));
    }
}
