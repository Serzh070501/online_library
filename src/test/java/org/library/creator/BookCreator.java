package org.library.creator;

import org.library.model.entity.Book;
import org.library.model.entity.Card;
import org.library.rest.dto.BookDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookCreator {
    public static final String TITLE = "Animal Farm";
    public static final String AUTHOR = "George Orwell";
    public static final String GENRE = "Novell";
    public static final String DESCRIPTION = "Best Book";
    public static final long ISBN = 567;
    public static final String IMAGE_URL = "https://source.unsplash.com/user/c_v_r/1900x800";
    public static final String PUBLISHER = "John Wick";
    public static final Date PUBLISHED = new Date();
    public static final double PRICE = 12.3;

    public static BookDTO createBook() {
        BookDTO testBook = new BookDTO();
        testBook.setPrice(PRICE);
        testBook.setTitle(TITLE);
        testBook.setImageURL(IMAGE_URL);
        testBook.setAuthor(AUTHOR);
        testBook.setGenre(GENRE);
        testBook.setIsbn(ISBN);
        testBook.setPrice(PRICE);
        testBook.setPublished(PUBLISHED);
        testBook.setPublisher(PUBLISHER);
        testBook.setDescription(DESCRIPTION);

        return testBook;
    }


    public static Set<BookDTO> createTestBooks(){
        Set<BookDTO> testProducts = new HashSet<>();

        testProducts.add(createBook());
        testProducts.add(createBook());
        testProducts.add(createBook());

        return testProducts;
    }





}
