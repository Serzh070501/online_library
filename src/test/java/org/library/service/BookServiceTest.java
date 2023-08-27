package org.library.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.creator.BookCreator;

import org.library.rest.dto.BookDTO;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @MockBean
    BookService bookService;

    @Test
    public void checkIfBookServiceIsNotNull(){
        initMocks(this);
        assertThat(bookService).isNotNull();
    }

    @Test
    public void saveBookTests(){
        BookDTO bookDTO = BookCreator.createBook();
        bookService.create(bookDTO);
        when(bookService.findByTitle(bookDTO.getTitle())).thenReturn(bookDTO);
        BookDTO found = bookService.findByTitle(bookDTO.getTitle());

        assertThat(found).isNotNull();
        assertThat(found.getAuthor()).isEqualTo(bookDTO.getAuthor());
        assertThat(found.getDescription()).isEqualTo(bookDTO.getDescription());
        assertThat(found.getPrice()).isEqualTo(bookDTO.getPrice());
        assertThat(found.getGenre()).isEqualTo(bookDTO.getGenre());
        assertThat(found.getImageURL()).isEqualTo(bookDTO.getImageURL());
        assertThat(found.getTitle()).isEqualTo(bookDTO.getTitle());
        assertThat(found.getIsbn()).isEqualTo(bookDTO.getIsbn());
        assertThat(found.getPublished()).isEqualTo(bookDTO.getPublished());
        assertThat(found.getPublisher()).isEqualTo(bookDTO.getPublisher());

    }


    @Test
    public void getBookByTitleTest(){
        when(bookService.findByTitle("Animal Farm")).thenReturn(BookCreator.createBook());
        BookDTO found = bookService.findByTitle("Animal Farm");

        assertThat(found).isNotNull();
        assertThat(found.getAuthor()).isEqualTo(BookCreator.AUTHOR);
        assertThat(found.getTitle()).isEqualTo(BookCreator.TITLE);
        assertThat(found.getPrice()).isEqualTo(BookCreator.PRICE);
        assertThat(found.getGenre()).isEqualTo(BookCreator.GENRE);
        assertThat(found.getDescription()).isEqualTo(BookCreator.DESCRIPTION);
        assertThat(found.getIsbn()).isEqualTo(BookCreator.ISBN);
        assertThat(found.getImageURL()).isEqualTo(BookCreator.IMAGE_URL);
        assertThat(found.getPublisher()).isEqualTo(BookCreator.PUBLISHER);
        assertThat(found.getPublished()).isEqualTo(BookCreator.PUBLISHED);

    }


    @Test
    public void deleteBookTest(){
        BookDTO bookDTO = BookCreator.createBook();
        bookService.create(bookDTO);
        bookService.deleteByTitle(bookDTO.getTitle());

        BookDTO found = bookService.findByTitle(bookDTO.getTitle());

        assertThat(found).isNull();

    }


    @Test
    public void whenFindAllByAuthorProducts(){
        ArrayList<BookDTO> books = new ArrayList<>(BookCreator.createTestBooks());
        when(bookService.findAllBooksByAuthor("George Orwell")).thenReturn(books);
        List<BookDTO> found = bookService.findAllBooksByAuthor("George Orwell");

        assertThat(found).isNotNull();
        for (BookDTO book : found){
            assertThat(book).isNotNull();
            assertThat(book.getAuthor()).isEqualTo(BookCreator.AUTHOR);
            assertThat(book.getTitle()).isEqualTo(BookCreator.TITLE);
            assertThat(book.getPrice()).isEqualTo(BookCreator.PRICE);
            assertThat(book.getGenre()).isEqualTo(BookCreator.GENRE);
            assertThat(book.getDescription()).isEqualTo(BookCreator.DESCRIPTION);
            assertThat(book.getIsbn()).isEqualTo(BookCreator.ISBN);
            assertThat(book.getImageURL()).isEqualTo(BookCreator.IMAGE_URL);
            assertThat(book.getPublisher()).isEqualTo(BookCreator.PUBLISHER);
            assertThat(book.getPublished()).isEqualTo(BookCreator.PUBLISHED);
        }
    }






}
