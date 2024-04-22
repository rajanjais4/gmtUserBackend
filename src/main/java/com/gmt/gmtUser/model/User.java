package com.gmt.gmtUser.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String userId;
    @NonNull
    private Long phoneNumber;
    @NonNull
    private String name;
    @NonNull
    private Long userCreationEpoch;
    @NonNull
    private String password;
}