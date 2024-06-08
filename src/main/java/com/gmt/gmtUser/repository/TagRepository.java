package com.gmt.gmtUser.repository;

import com.gmt.gmtUser.model.common.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
}