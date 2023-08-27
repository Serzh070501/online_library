package org.library.service;

import org.library.rest.dto.CardDTO;

public interface CardService {

    CardDTO addCard(CardDTO cardDTO);

    void deleteById(Long id);

    CardDTO getById(Long id);
}
