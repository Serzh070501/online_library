package org.library.rest.controller;

import org.library.rest.dto.BookDTO;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping()
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.create(bookDTO));
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BookDTO> getBookByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(bookService.findByTitle(title));

    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable("author") String author){
        return ResponseEntity.ok(bookService.findAllBooksByAuthor(author));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@PathVariable("genre") String genre){
        return ResponseEntity.ok(bookService.findAllBooksByGenre(genre));
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookDTO>> getBooksByPublisher(@PathVariable("publisher") String publisher){
        return ResponseEntity.ok(bookService.findAllBooksByPublisher(publisher));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDTO> getBooksByPublisher(@PathVariable("isbn") long isbn){
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        bookService.deleteById(id);
        return ResponseEntity.ok("Book was deleted successfully");
    }

    @PutMapping("/")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO ){
        return ResponseEntity.ok(bookService.update(bookDTO));
    }

    @GetMapping("/preferences/user/{id}")
    public ResponseEntity<List<BookDTO>> getPreferences(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(bookService.getPreferences(id));
    }
}




















