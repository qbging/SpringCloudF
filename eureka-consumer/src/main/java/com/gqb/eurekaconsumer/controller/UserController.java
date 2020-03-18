package com.gqb.eurekaconsumer.controller;

import com.gqb.eurekaconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cons")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/msg")
    public String getMsg() {
        return userService.getMsg();
    }
}
