package com.gmt.gmtUser.service;

import com.gmt.gmtUser.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(User user) {
        return user;
    }
}
