package org.library.convertor;

import org.library.model.entity.Order;
import org.library.rest.dto.OrderDTO;

import java.util.List;

public interface OrderConvertor {
    Order convertToEntity(OrderDTO orderDTO);

    OrderDTO convertToDTO(Order order);

    List<OrderDTO> bulkConvert(List<Order> orders);
}
