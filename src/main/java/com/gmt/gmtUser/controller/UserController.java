package com.gmt.gmtUser.controller;


import com.gmt.gmtUser.model.User;
import com.gmt.gmtUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String addUser() {
//        return userService.createUser(user);
        return "success";
    }
}