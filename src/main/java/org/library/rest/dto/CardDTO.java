package org.library.rest.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class CardDTO {

    private Long id;
    private String fullName;
    private String pan;
    private Date expDate;
    private int cvv;
}
