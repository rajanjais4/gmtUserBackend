package com.gmt.gmtUser.service;

import com.gmt.gmtUser.model.itinerary.PointOfInterest;
import com.gmt.gmtUser.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PointOfInterestService {
    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    @Autowired
    private SequenceService sequenceService;

    public PointOfInterest createPointOfInterest(PointOfInterest pointOfInterest) {
        pointOfInterest.setId(Long.toString(sequenceService.getNextSequence("pointsOfInterest_sequence")));
        return pointOfInterestRepository.save(pointOfInterest);
    }

    public PointOfInterest updatePointOfInterest(String id, PointOfInterest pointOfInterestDetails) {
        Optional<PointOfInterest> pointOfInterestOptional = pointOfInterestRepository.findById(id);
        if (pointOfInterestOptional.isPresent()) {
            PointOfInterest pointOfInterest = pointOfInterestOptional.get();
            pointOfInterest.setName(pointOfInterestDetails.getName());
            pointOfInterest.setPlaceId(pointOfInterestDetails.getPlaceId());
            pointOfInterest.setLocation(pointOfInterestDetails.getLocation());
            pointOfInterest.setTagsScore(pointOfInterestDetails.getTagsScore());
            pointOfInterest.setDescription(pointOfInterestDetails.getDescription());
            pointOfInterest.setPopularity(pointOfInterestDetails.getPopularity());
            pointOfInterest.setOpenTime(pointOfInterestDetails.getOpenTime());
            pointOfInterest.setCloseTime(pointOfInterestDetails.getCloseTime());
            pointOfInterest.setCreatedAt(pointOfInterestDetails.getCreatedAt());
            pointOfInterest.setUpdatedAt(pointOfInterestDetails.getUpdatedAt());
            return pointOfInterestRepository.save(pointOfInterest);
        }
        return null;
    }

    public void deletePointOfInterest(String id) {
        pointOfInterestRepository.deleteById(id);
    }

    public List<PointOfInterest> getAllPointsOfInterest() {
        return pointOfInterestRepository.findAll();
    }

    public Optional<PointOfInterest> getPointOfInterestById(String id) {
        return pointOfInterestRepository.findById(id);
    }
}