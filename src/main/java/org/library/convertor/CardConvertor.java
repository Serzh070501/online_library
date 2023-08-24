package org.library.convertor;

import org.library.model.entity.Card;
import org.library.rest.dto.CardDTO;

public interface CardConvertor {

    Card convertToEntity(CardDTO cardDTO);

    CardDTO convertToDTO(Card Card);
}
