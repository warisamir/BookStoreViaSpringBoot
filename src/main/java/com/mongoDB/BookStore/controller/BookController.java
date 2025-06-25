package com.mongoDB.BookStore.controller;

import com.mongoDB.BookStore.dto.BookDto;
import com.mongoDB.BookStore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookStore")
@RestController
public class BookController {

    BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage(){
        return new ResponseEntity<>("Welcome to this site",HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<BookDto> getBook(@PathVariable  String bookId){
        BookDto bookDto= bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBook(){
        List<BookDto> bookDtoList=bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList,HttpStatus.OK);
    }

    @PostMapping("/createBook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto bookDto1=bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @PutMapping("/updateBook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        BookDto bookDto1= bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteBook/{bookId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("book deleted successfullly"+bookId, HttpStatus.OK);
    }

}
