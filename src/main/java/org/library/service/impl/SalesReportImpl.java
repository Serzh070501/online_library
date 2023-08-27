package org.library.service.impl;

import org.library.model.entity.Order;
import org.library.repository.OrderRepository;
import org.library.rest.response.SalesReportResponse;
import org.library.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SalesReportImpl implements SalesReportService {

    @Autowired
    OrderRepository orderRepository;


    public List<Order> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByDateBetween(startDate.atStartOfDay(), endDate.plusDays(1).atStartOfDay());
    }

    public double calculateTotalSales(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getPrice).sum();
    }

    public SalesReportResponse generateSalesReport(LocalDate startDate, LocalDate endDate){
        List<Order> orders = getOrdersBetweenDates(startDate, endDate);
        double totalSales = calculateTotalSales(orders);
        SalesReportResponse response = new SalesReportResponse(orders, totalSales);
        return response;
    }
}
