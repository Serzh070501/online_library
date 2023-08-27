package org.library.service;

import org.library.rest.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    OrderDTO getById(UUID id);

    List<OrderDTO> getAll();

    OrderDTO create(OrderDTO dto);

    List<OrderDTO> getByUserId(UUID userId);

    List<OrderDTO> getByTitle(String title);

    List<OrderDTO> getByAuthor(String author);

}
