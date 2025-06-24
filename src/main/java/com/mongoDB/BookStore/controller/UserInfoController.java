package com.mongoDB.BookStore.controller;

import com.mongoDB.BookStore.dto.UserInfoDto;
import com.mongoDB.BookStore.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")

public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDto userInfoDto){
        UserInfoDto userInfoDto1=userInfoService.createUser(userInfoDto);
        return new ResponseEntity<>("User"+userInfoDto1.userName()+"is created", HttpStatus.CREATED);
    }

}
