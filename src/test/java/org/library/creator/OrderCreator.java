package org.library.creator;


import org.library.convertor.BookConvertor;
import org.library.model.entity.Order;
import org.library.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.UUID;


public class OrderCreator {

    public static final double PRICE = 12.3;
    public static final LocalDateTime DATE = LocalDateTime.now();
    public static final long CARD_ID = 12345;

    @Autowired
    BookConvertor bookConvertor;


    public static OrderDTO createOrder() {
        OrderDTO testOrder = new OrderDTO();
        testOrder.setUserId(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"));
        testOrder.setPrice(PRICE);
        testOrder.setDate(DATE);
        testOrder.setCardId(CARD_ID);
        testOrder.setBookId(100L);

        return testOrder;
    }




}
