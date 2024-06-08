package com.gmt.gmtUser.model.common;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(collection = "tags")
public class Tag {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String type; // "place" or "poi"
    private int popularity;

    // Getters and setters
}
