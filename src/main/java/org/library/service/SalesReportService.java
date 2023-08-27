package org.library.service;

import org.library.rest.response.SalesReportResponse;

import java.time.LocalDate;

public interface SalesReportService {
    public SalesReportResponse generateSalesReport(LocalDate startDate, LocalDate endDate);

}
