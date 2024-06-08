package com.gmt.gmtUser.controller;

import com.gmt.gmtUser.model.itinerary.Place;
import com.gmt.gmtUser.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable String id, @RequestBody Place placeDetails) {
        Place updatedPlace = placeService.updatePlace(id, placeDetails);
        if (updatedPlace != null) {
            return ResponseEntity.ok(updatedPlace);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable String id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable String id) {
        Optional<Place> place = placeService.getPlaceById(id);
        if (place.isPresent()) {
            return ResponseEntity.ok(place.get());
        }
        return ResponseEntity.notFound().build();
    }
}
