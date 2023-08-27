package org.library.creator;


import org.library.convertor.CardConvertor;
import org.library.model.entity.Card;
import org.library.rest.dto.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;


public class CardCreator {

    @MockBean
    CardConvertor cardConvertor;

    public static final String FULL_NAME = "John Wick";
    public static final String PAN = "1234 1234 1234 1234";
    public static final Date DATE = new Date();
    public static final int CVV = 123;

    public static CardDTO createCard() {
        CardDTO testCard = new CardDTO();
        testCard.setFullName(FULL_NAME);
        testCard.setPan(PAN);
        testCard.setExpDate(DATE);
        testCard.setCvv(CVV);

        return testCard;

    }


}
