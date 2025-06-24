package com.mongoDB.BookStore.service.Impl;

import com.mongoDB.BookStore.dto.UserInfoDto;
import com.mongoDB.BookStore.entity.UserInfo;
import com.mongoDB.BookStore.mapper.UserInfoMapper;
import com.mongoDB.BookStore.repository.UserInfoRepository;
import com.mongoDB.BookStore.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
//        System.out.println("serivcelayer"+ userInfo);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return UserInfoMapper.toDto(userInfo);
    }
}
