package org.library.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.creator.CardCreator;
import org.library.rest.dto.CardDTO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

    @MockBean
    private CardService cardService;


    @Test
    public void checkIfCardServiceIsNotNull(){
        initMocks(this);
        assertThat(cardService).isNotNull();
    }

    @Test
    public void saveCardTest(){
        CardDTO cardDTO = CardCreator.createCard();
        cardService.addCard(cardDTO);
        when(cardService.getById(cardDTO.getId())).thenReturn(cardDTO);
        CardDTO found = cardService.getById(cardDTO.getId());

        assertThat(found).isNotNull();
        assertThat(found.getFullName()).isEqualTo(cardDTO.getFullName());
        assertThat(found.getCvv()).isEqualTo(cardDTO.getCvv());
        assertThat(found.getExpDate()).isEqualTo(cardDTO.getExpDate());
        assertThat(found.getPan()).isEqualTo(cardDTO.getPan());
    }

    @Test
    public void deleteCardTest(){
        CardDTO cardDTO = CardCreator.createCard();
        cardService.addCard(cardDTO);
        cardService.deleteById(cardDTO.getId());

        CardDTO found = cardService.getById(cardDTO.getId());

        assertThat(found).isNull();

    }


    @Test
    public void getCardByIdTest(){
        when(cardService.getById(100L)).thenReturn(CardCreator.createCard());
        CardDTO found = cardService.getById(100L);

        assertThat(found).isNotNull();
        assertThat(found.getFullName()).isEqualTo(CardCreator.FULL_NAME);
        assertThat(found.getCvv()).isEqualTo(CardCreator.CVV);
        assertThat(found.getExpDate()).isEqualTo(CardCreator.DATE);
        assertThat(found.getPan()).isEqualTo(CardCreator.PAN);
    }




}
