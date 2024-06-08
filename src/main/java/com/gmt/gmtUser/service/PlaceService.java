package com.gmt.gmtUser.service;

import com.gmt.gmtUser.model.itinerary.Place;
import com.gmt.gmtUser.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private SequenceService sequenceService;

    public Place createPlace(Place place) {
        place.setId(Long.toString(sequenceService.getNextSequence("places_sequence")));
        return placeRepository.save(place);
    }

    public Place updatePlace(String id, Place placeDetails) {
        Optional<Place> placeOptional = placeRepository.findById(id);
        if (placeOptional.isPresent()) {
            Place place = placeOptional.get();
            place.setName(placeDetails.getName());
            place.setLocation(placeDetails.getLocation());
            place.setDescription(placeDetails.getDescription());
            place.setImages(placeDetails.getImages());
            place.setPopularity(placeDetails.getPopularity());
            place.setTagsScore(placeDetails.getTagsScore());
            place.setPoi(placeDetails.getPoi());
            place.setCreatedAt(placeDetails.getCreatedAt());
            place.setUpdatedAt(placeDetails.getUpdatedAt());
            return placeRepository.save(place);
        }
        return null;
    }

    public void deletePlace(String id) {
        placeRepository.deleteById(id);
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Optional<Place> getPlaceById(String id) {
        return placeRepository.findById(id);
    }
}