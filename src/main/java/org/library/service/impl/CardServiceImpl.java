package org.library.service.impl;


import org.library.convertor.CardConvertor;
import org.library.model.entity.Card;
import org.library.repository.CardRepository;
import org.library.rest.dto.CardDTO;
import org.library.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardConvertor cardConvertor;

    @Override
    public CardDTO addCard(CardDTO cardDTO) {
        return cardConvertor.convertToDTO(cardRepository.save(cardConvertor.convertToEntity(cardDTO)));
    }

    @Override
    public void deleteCard(CardDTO cardDTO) {
        cardRepository.delete(cardConvertor.convertToEntity(cardDTO));
    }
}
