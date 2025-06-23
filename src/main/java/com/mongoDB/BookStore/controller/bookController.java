package com.mongoDB.BookStore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bookStore")
@RestController
public class bookController {
    @GetMapping("/{bookId}")
    public ResponseEntity<String> getBook(@PathVariable  String bookId){
        return new ResponseEntity<>("Book found"+ bookId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllBook(){
        List<String>books= new ArrayList<>();
        books.add("Java");
        books.add("MongoDB");
        books.add("SpringBoot");
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(String book){
        return new ResponseEntity<>("book created", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBook(String bookId) {
        return new ResponseEntity<>("book updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(String bookId){
        return new ResponseEntity<>("book deleted successfullly", HttpStatus.OK);
    }

}
