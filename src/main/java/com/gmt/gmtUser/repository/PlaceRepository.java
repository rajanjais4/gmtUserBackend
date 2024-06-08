package com.gmt.gmtUser.repository;
import com.gmt.gmtUser.model.itinerary.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {
}
