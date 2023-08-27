package org.library.rest.response;

import lombok.Getter;
import lombok.Setter;
import org.library.model.entity.Order;

import java.util.List;

@Getter
@Setter
public class SalesReportResponse {
    private List<Order> orders;
    private double totalSales;

    public SalesReportResponse(List<Order> orders, double totalSales) {
        this.orders = orders;
        this.totalSales = totalSales;
    }
}
