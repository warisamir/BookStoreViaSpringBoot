package com.mongoDB.BookStore.service.Impl;

import com.mongoDB.BookStore.dto.BookDto;
import com.mongoDB.BookStore.entity.Book;
import com.mongoDB.BookStore.mapper.BookMapper;
import com.mongoDB.BookStore.repository.BookRepository;
import com.mongoDB.BookStore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public BookDto getBook(String bookId) {
        Book book= bookRepository.findByBookId(bookId);
        BookDto bookDto= BookMapper.toDto(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books=bookRepository.findAll();
        List<BookDto>bookDtoList=new ArrayList<>();
        for(Book book:books){
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book=bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        Book book=bookRepository.findByBookId(bookDto.bookId());
        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }
}
