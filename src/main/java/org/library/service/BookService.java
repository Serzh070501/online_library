package org.library.service;

import org.library.rest.dto.BookDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookDTO create(BookDTO bookDTO);

    BookDTO findByTitle(String title);

    void deleteById(Long id);

    BookDTO findByIsbn(long isbn);

    BookDTO update (BookDTO bookDTO);

    void deleteByTitle(String title);
    List<BookDTO> findAllBooks();
    List<BookDTO> findAllBooksByAuthor(String author);

    List<BookDTO> findAllBooksByGenre(String genre);

    List<BookDTO> findAllBooksByPublisher(String publisher);

    BookDTO findById(Long id);

    List<BookDTO> getPreferences(UUID userId);
}
