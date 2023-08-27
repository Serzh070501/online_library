package org.library.service.impl;


import org.library.convertor.CardConvertor;
import org.library.model.entity.Card;
import org.library.repository.CardRepository;
import org.library.rest.dto.CardDTO;
import org.library.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);


    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardConvertor cardConvertor;

    @Override
    public CardDTO addCard(CardDTO cardDTO) {
        logger.info("Adding card for User " + cardDTO.getId());
        return cardConvertor.convertToDTO(cardRepository.save(cardConvertor.convertToEntity(cardDTO)));
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting card " + id);
        cardRepository.deleteById(id);
    }

    @Override
    public CardDTO getById(Long id) {
        logger.info("getting card by ID" + id);
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Not found card by this id%d", id)));
        return cardConvertor.convertToDTO(card);
    }
}
