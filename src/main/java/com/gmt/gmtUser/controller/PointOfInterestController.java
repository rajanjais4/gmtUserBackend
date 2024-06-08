package com.gmt.gmtUser.controller;

import com.gmt.gmtUser.model.itinerary.PointOfInterest;
import com.gmt.gmtUser.service.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pointsOfInterest")
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @PostMapping
    public PointOfInterest createPointOfInterest(@RequestBody PointOfInterest pointOfInterest) {
        return pointOfInterestService.createPointOfInterest(pointOfInterest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PointOfInterest> updatePointOfInterest(@PathVariable String id, @RequestBody PointOfInterest pointOfInterestDetails) {
        PointOfInterest updatedPointOfInterest = pointOfInterestService.updatePointOfInterest(id, pointOfInterestDetails);
        if (updatedPointOfInterest != null) {
            return ResponseEntity.ok(updatedPointOfInterest);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePointOfInterest(@PathVariable String id) {
        pointOfInterestService.deletePointOfInterest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<PointOfInterest> getAllPointsOfInterest() {
        return pointOfInterestService.getAllPointsOfInterest();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointOfInterest> getPointOfInterestById(@PathVariable String id) {
        Optional<PointOfInterest> pointOfInterest = pointOfInterestService.getPointOfInterestById(id);
        if (pointOfInterest.isPresent()) {
            return ResponseEntity.ok(pointOfInterest.get());
        }
        return ResponseEntity.notFound().build();
    }
}
