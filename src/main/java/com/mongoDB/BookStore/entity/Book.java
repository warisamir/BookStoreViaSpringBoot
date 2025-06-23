package com.mongoDB.BookStore.entity;

public record Book(String bookId, String name, String price, String author,String description) {
}
