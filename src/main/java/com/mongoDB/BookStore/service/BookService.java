package com.mongoDB.BookStore.service;

import com.mongoDB.BookStore.dto.BookDto;
import com.mongoDB.BookStore.entity.Book;
import org.springframework.stereotype.Service;


import java.util.List;

public interface BookService {
    public BookDto getBook(String bookId);
    public List<BookDto> getAllBooks();
    public BookDto createBook(BookDto bookDto);
    public BookDto updateBookName(BookDto bookDto);
    public void deleteBookByBookId(String bookId);
}
