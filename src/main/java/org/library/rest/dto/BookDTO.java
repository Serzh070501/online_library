package org.library.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BookDTO {
    private UUID id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private long isbn;
    private String imageURL;
    private String publisher;
    private Date published;
    private double price;
}
