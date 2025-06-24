package com.mongoDB.BookStore.dto;
import org.springframework.beans.PropertyValues;

public record UserInfoDto(String userName, String password, String roles) {

}
