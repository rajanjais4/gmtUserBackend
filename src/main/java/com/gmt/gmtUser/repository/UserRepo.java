package com.gmt.gmtUser.repository;

import com.gmt.gmtUser.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findByPhoneNumber(Long phoneNumber);
}
