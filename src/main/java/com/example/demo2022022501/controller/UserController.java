package com.example.demo2022022501.controller;

import com.example.demo2022022501.entity.PageEntity;
import com.example.demo2022022501.entity.UserEntity;
import com.example.demo2022022501.result.ResultData;
import com.example.demo2022022501.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/getAllUser")
    public ResultData<Page<UserEntity>> getAllUser(UserEntity userEntity, PageEntity pageEntity){
        return userService.getAllUser(userEntity,pageEntity);
    }

    @RequestMapping("/addUser")
    public ResultData<Object> addUser(UserEntity userEntity){
        return  userService.addUser(userEntity);
    }

    @RequestMapping("/deleteUserById")
    public ResultData<Object> deleteUserById(UserEntity userEntity){
        return  userService.deleteUserById(userEntity);
    }

    @RequestMapping("/updateUserById")
    public ResultData<Object> updateUserById(UserEntity userEntity){
        return  userService.updateUserById(userEntity);
    }
}
