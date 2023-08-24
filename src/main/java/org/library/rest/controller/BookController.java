package org.library.rest.controller;

import org.library.convertor.BookConvertor;
import org.library.rest.dto.BookDTO;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class BookController {

    @Autowired
    BookService bookService;


    //TODO check BookDTO or Book
//    @PostMapping("/")
//    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO){
//        return ResponseEntity.ok(bookService.create(bookDTO));
//    }

//    @GetMapping("/")
//    public ResponseEntity<BookDTO> getBookByTitle(@RequestParam("title") String title){
//        return ResponseEntity.ok(bookService.findByTitle(title));
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@RequestParam("author") String author){
//        return ResponseEntity.ok(bookService.findAllBooksByAuthor(author));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BookDTO>> getBooksByGenre(@RequestParam("genre") String genre){
//        return ResponseEntity.ok(bookService.findAllBooksByGenre(genre));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BookDTO>> getBooksByPublisher(@RequestParam("publisher") String publisher){
//        return ResponseEntity.ok(bookService.findAllBooksByPublisher(publisher));
//    }
//
//    @GetMapping
//    public ResponseEntity<BookDTO> getBooksByPublisher(@RequestParam("isbn") long isbn){
//        return ResponseEntity.ok(bookService.findByIsbn(isbn));
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<String> delete(@RequestParam("title") String title){
//        bookService.deleteByTitle(title);
//        return ResponseEntity.ok("Book was deleted successfully");
//    }
//
//    @PutMapping("/")
//    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO){
//        return ResponseEntity.ok(bookService.update(bookDTO));
//    }
//








}




















