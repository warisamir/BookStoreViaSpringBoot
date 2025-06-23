package com.mongoDB.BookStore.dto;

public record BookDto(String bookId, String name, String price, String author, String description) {
}
