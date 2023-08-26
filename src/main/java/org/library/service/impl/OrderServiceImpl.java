package org.library.service.impl;

import org.library.convertor.OrderConvertor;
import org.library.repository.OrderRepository;
import org.library.rest.dto.OrderDTO;
import org.library.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConvertor orderConvertor;

    @Override
    public OrderDTO getById(UUID id) {
        logger.info("Finding order by ID =" + id);
        return orderConvertor.convertToDTO(orderRepository.getById(id));

    }

    @Override
    public List<OrderDTO> getAll() {
        logger.info("Getting all orders");
        return orderConvertor.bulkConvert(orderRepository.findAll());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        logger.info("Creating new order " + orderDTO.getId());
        return orderConvertor.convertToDTO(orderRepository.save(orderConvertor.convertToEntity(orderDTO)));
    }

    @Override
    public List<OrderDTO> getByUserId(UUID userId) {
        logger.info("Getting orders by UserId " + userId );
        return orderConvertor.bulkConvert(orderRepository.findByUserId(userId));

    }

    @Override
    public List<OrderDTO> getByTitle(String title) {
        logger.info("Getting orders by Book title " + title);
        return orderConvertor.bulkConvert(orderRepository.findByBooksTitle(title));
    }

    @Override
    public List<OrderDTO> getByAuthor(String author) {
        logger.info("Getting orders bt author " + author);
        return orderConvertor.bulkConvert(orderRepository.findByBooksAuthor(author));
    }




}
