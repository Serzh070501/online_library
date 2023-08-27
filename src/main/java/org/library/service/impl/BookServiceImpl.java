package org.library.service.impl;


import org.library.convertor.BookConvertor;
import org.library.model.entity.Book;
import org.library.model.entity.User;
import org.library.repository.BookRepository;
import org.library.repository.UserRepository;
import org.library.rest.dto.BookDTO;
import org.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
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
    public void deleteById(Long id) {
        logger.info("Deleting book By id " + id);
        bookRepository.deleteById(id);
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
    public BookDTO findById(Long id) {
        logger.info("Finding book by id " + id);
        return bookConvertor.convertToDTO(bookRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found book with id - " + id);
        }));
    }

    @Override
    public List<BookDTO> getPreferences(UUID userId) {
        logger.info("Getting preferences for user with id - {}", userId);

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return Collections.emptyList();
        }
        List<Book> books = optionalUser.get().getBooks();

        Optional<Book> optionalBook = books.stream().findAny();
        if (optionalBook.isEmpty()) {
            return findAllBooks();
        }
        Book randomBook = optionalBook.get();

        List<BookDTO> bookDtoList = new LinkedList<>();

        bookRepository.findAllBooksByAuthor(randomBook.getAuthor()).stream()
                .limit(2)
                .map(bookConvertor::convertToDTO)
                .forEach(bookDtoList::add);
        bookRepository.findAllBooksByGenre(randomBook.getAuthor()).stream()
                .limit(2)
                .map(bookConvertor::convertToDTO)
                .forEach(bookDtoList::add);
        bookRepository.findAllBooksByPublisher(randomBook.getAuthor()).stream()
                .limit(2)
                .map(bookConvertor::convertToDTO)
                .forEach(bookDtoList::add);

        return bookDtoList;
    }

    @Override
    public List<BookDTO> findAllBooks() {
        return bookConvertor.bulkConvert(bookRepository.findAll());
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
