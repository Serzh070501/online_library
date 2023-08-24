package org.library.convertor.impl;

import org.library.convertor.CardConvertor;
import org.library.model.entity.Card;
import org.library.rest.dto.CardDTO;
import org.springframework.stereotype.Component;

@Component
public class CardConverterImpl implements CardConvertor {
    @Override
    public Card convertToEntity(CardDTO cardDTO) {
        Card card = new Card();

        card.setCvv(cardDTO.getCvv());
        card.setId(cardDTO.getId());
        card.setPan(cardDTO.getPan());
        card.setExpDate(cardDTO.getExpDate());
        card.setFullName(cardDTO.getFullName());

        return card;
    }

    @Override
    public CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();

        cardDTO.setCvv(card.getCvv());
        cardDTO.setId(card.getId());
        cardDTO.setPan(card.getPan());
        cardDTO.setExpDate(card.getExpDate());
        cardDTO.setFullName(card.getFullName());

        return cardDTO;
    }
}
