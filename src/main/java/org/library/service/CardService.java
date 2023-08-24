package org.library.service;

import org.library.model.entity.Card;
import org.library.rest.dto.CardDTO;

public interface CardService {

    CardDTO addCard(CardDTO cardDTO);

    void deleteCard(CardDTO cardDTO);
}
