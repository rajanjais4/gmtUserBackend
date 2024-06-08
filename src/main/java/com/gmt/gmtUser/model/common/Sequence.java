package com.gmt.gmtUser.model.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "sequences")
public class Sequence {
    @Id
    private String id;
    private long seq;
}