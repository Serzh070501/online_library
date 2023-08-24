package org.library.service;

import org.library.model.entity.Book;
import org.library.rest.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO create(BookDTO bookDTO);

    BookDTO findByTitle(String title);

    BookDTO findByIsbn(long isbn);

    BookDTO update (BookDTO bookDTO);

    void deleteByTitle(String title);

    List<BookDTO> findAllBooksByAuthor(String author);

    List<BookDTO> findAllBooksByGenre(String genre);

    List<BookDTO> findAllBooksByPublisher(String publisher);

}
