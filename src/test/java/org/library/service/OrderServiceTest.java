package org.library.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.creator.CardCreator;
import org.library.creator.OrderCreator;
import org.library.rest.dto.CardDTO;
import org.library.rest.dto.OrderDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @MockBean
    private OrderService orderService;


    @Test
    public void checkIfOrderServiceIsNotNull(){
        initMocks(this);
        assertThat(orderService).isNotNull();
    }

    @Test
    public void getOrderByIdTest(){
        when(orderService.getById(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"))).thenReturn(OrderCreator.createOrder());
        OrderDTO found = orderService.getById(UUID.fromString("a57bdf71-d31e-4408-952e-8ee47803642c"));

        assertThat(found).isNotNull();
        assertThat(found.getCardId()).isEqualTo(OrderCreator.CARD_ID);
        assertThat(found.getDate()).isEqualTo(OrderCreator.DATE);
        assertThat(found.getPrice()).isEqualTo(OrderCreator.PRICE);
    }





}
