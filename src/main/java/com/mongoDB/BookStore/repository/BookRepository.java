package com.mongoDB.BookStore.repository;

import com.mongoDB.BookStore.entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

//mongo repository is responsible for talking to database just like JPARepository
public interface BookRepository extends MongoRepository<Book,String> {
    //'?0' method argument which indicate the first parameter
    @Query("{bookId:'?0'}")
    Book findByBookId(String bookId);

    @Query(value="{'bookId':{$eq: ?0} }")
    @Update(pipeline = {"{'$set':{'name':?1}}"})
    void updateBookNameByBookId(String bookId, String name);

    @DeleteQuery
    void deleteBookByBookId(String bookId);
}
