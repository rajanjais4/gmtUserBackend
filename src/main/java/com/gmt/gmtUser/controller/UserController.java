package com.gmt.gmtUser.controller;


import com.gmt.gmtUser.dto.UserSignupDto;
import com.gmt.gmtUser.model.User;
import com.gmt.gmtUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserSignupDto userLogInDto) {
        return ResponseEntity.ok(userService.addUserToDb(userLogInDto));
    }
}