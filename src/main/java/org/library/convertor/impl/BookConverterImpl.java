package org.library.convertor.impl;

import org.library.convertor.BookConvertor;
import org.library.model.entity.Book;
import org.library.rest.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverterImpl implements BookConvertor {
    @Override
    public Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();

        book.setId(bookDTO.getId());
        book.setDescription(bookDTO.getDescription());
        book.setIsbn(bookDTO.getIsbn());
        book.setGenre(bookDTO.getGenre());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setPublished(bookDTO.getPublished());
        book.setTitle(bookDTO.getTitle());
        book.setPublisher(bookDTO.getPublisher());
        book.setImageURL(bookDTO.getImageURL());

        return book;
    }

    @Override
    public BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setDescription(book.getDescription());
        dto.setIsbn(book.getIsbn());
        dto.setGenre(book.getGenre());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        dto.setPublished(book.getPublished());
        dto.setTitle(book.getTitle());
        dto.setPublisher(book.getPublisher());
        dto.setImageURL(book.getImageURL());

        return dto;
    }

    @Override
    public List<BookDTO> bulkConvert(List<Book> books) {
        return books.stream().map(this::convertToDTO)
                .collect(Collectors.toList());

    }
}
