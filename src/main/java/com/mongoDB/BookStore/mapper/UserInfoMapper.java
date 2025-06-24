package com.mongoDB.BookStore.mapper;

import com.mongoDB.BookStore.dto.UserInfoDto;
import com.mongoDB.BookStore.entity.UserInfo;
import lombok.Data;

@Data
public class UserInfoMapper {
    public static UserInfoDto toDto(UserInfo userInfo){
        return new UserInfoDto(userInfo.getUserName(), userInfo.getPassword(), userInfo.getRoles());
    }
    public static UserInfo toEntity(UserInfoDto userInfoDto){
        return  new UserInfo(userInfoDto.userName(),userInfoDto.password(),userInfoDto.roles());
    }
}
