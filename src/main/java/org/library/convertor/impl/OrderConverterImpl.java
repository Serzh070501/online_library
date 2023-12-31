package org.library.convertor.impl;

import org.library.convertor.OrderConvertor;
import org.library.convertor.UserConverter;
import org.library.model.entity.Order;
import org.library.rest.dto.OrderDTO;
import org.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class OrderConverterImpl implements OrderConvertor {

    private static final Logger logger = LoggerFactory.getLogger(OrderConverterImpl.class);


    @Autowired
    UserService userService;
    @Autowired
    UserConverter userConverter;

    @Override
    public Order convertToEntity(OrderDTO orderDTO) {
        logger.info("start convert to Entity");

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setDate(orderDTO.getDate());
        order.setPrice(orderDTO.getPrice());
        order.setCardId(orderDTO.getCardId());
        order.setUser(userConverter.convertToEntity(userService.findById(orderDTO.getUserId())));

        return order;

    }

    @Override
    public OrderDTO convertToDTO(Order order) {
        logger.info("start convert to DTO");

        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setPrice(order.getPrice());
        dto.setCardId(order.getCardId());
        dto.setUserId(order.getUser().getId());

        return dto;
    }

    @Override
    public List<OrderDTO> bulkConvert(List<Order> orders) {
        return orders.stream().map(this::convertToDTO)
                .collect(Collectors.toList());

    }
}
