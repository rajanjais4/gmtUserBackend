package com.gmt.gmtUser.service;

import com.gmt.gmtUser.dto.UserSignupDto;
import com.gmt.gmtUser.model.User;
import com.gmt.gmtUser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    UserService(){
    }
    private User createUser(UserSignupDto userSignupDto){
        User user = new User();
        user.setUserId("U_"+userSignupDto.getPhoneNumber());
        user.setName(userSignupDto.getName());
        user.setPassword(userSignupDto.getPassword());
        user.setPhoneNumber(userSignupDto.getPhoneNumber());
        Long currentTimeEpoch= Instant.now().getEpochSecond();
        user.setUserCreationEpoch(currentTimeEpoch);
        return user;
    }
    public User addUserToDb(UserSignupDto userSignupDto) {
        User user = createUser(userSignupDto);
        userRepo.save(user);
        return user;
    }
}
