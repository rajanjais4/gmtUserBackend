package com.gmt.gmtUser.repository;

import com.gmt.gmtUser.model.itinerary.PointOfInterest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, String> {
}
