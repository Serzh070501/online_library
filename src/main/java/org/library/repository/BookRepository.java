package org.library.repository;


import org.library.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    Book findByIsbn(long isbn);

    void deleteByTitle(String title);

    List<Book> findAllBooksByAuthor(String author);

    List<Book> findAllBooksByGenre(String genre);

    List<Book> findAllBooksByPublisher(String publisher);


}
