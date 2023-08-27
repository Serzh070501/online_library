package org.library.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {
    private UUID id;
    private UUID userId;
    private Long bookId;
    private double price;
    private LocalDateTime date;
    private Long cardId;
}
