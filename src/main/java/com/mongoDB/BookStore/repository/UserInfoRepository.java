package com.mongoDB.BookStore.repository;

import com.mongoDB.BookStore.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    Optional<UserInfo> findByUserName(String userName);

}
