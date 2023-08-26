package org.library.service.impl;


import org.library.convertor.BookConvertor;
import org.library.convertor.impl.CardConverterImpl;
import org.library.model.entity.Book;
import org.library.repository.BookRepository;
import org.library.rest.dto.BookDTO;
import org.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookConvertor bookConvertor;


    @Override
    public BookDTO create(BookDTO bookDTO) {
        logger.info("Creating book " + bookDTO.getId());
        return bookConvertor.convertToDTO(bookRepository.save(bookConvertor.convertToEntity(bookDTO)));
    }

    @Override
    public BookDTO findByTitle(String title) {
        logger.info("Searching book by title " + title);
        BookDTO bookDTO = bookConvertor.convertToDTO(bookRepository.findByTitle(title));
        return bookDTO;
    }

    @Override
    public BookDTO findByIsbn(long isbn) {
        logger.info("Searching book by isbn " + isbn);
        BookDTO bookDTO = bookConvertor.convertToDTO(bookRepository.findByIsbn(isbn));
        return bookDTO;
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        logger.info("Updating book " + bookDTO.getId());

        Book existingBook = bookRepository.findByTitle(bookConvertor.convertToEntity(bookDTO).getTitle());

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setDescription(bookDTO.getDescription());
        existingBook.setGenre(bookDTO.getGenre());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setImageURL(bookDTO.getImageURL());
        Book updatedBook = bookRepository.save(existingBook);

        return bookConvertor.convertToDTO(updatedBook);

    }

    @Override
    public void deleteByTitle(String title) {
        logger.info("Deleting book by title " + title);
        bookRepository.deleteByTitle(title);
    }

    @Override
    public List<BookDTO> findAllBooksByAuthor(String author) {
        logger.info("Finding books same author " + author);
        return bookConvertor.bulkConvert(bookRepository.findAllBooksByAuthor(author));
    }

    @Override
    public List<BookDTO> findAllBooksByGenre(String genre) {
        logger.info("Finding books same genre " + genre);
        return bookConvertor.bulkConvert(bookRepository.findAllBooksByGenre(genre));
    }

    @Override
    public List<BookDTO> findAllBooksByPublisher(String publisher) {
        logger.info("Finding books same publisher " + publisher);
        return bookConvertor.bulkConvert(bookRepository.findAllBooksByPublisher(publisher));
    }
}
