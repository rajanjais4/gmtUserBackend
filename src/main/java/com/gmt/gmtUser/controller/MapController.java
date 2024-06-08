package com.gmt.gmtUser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmt.gmtUser.exception.ApiRequestException;
import com.gmt.gmtUser.exception.ApiRequestResponse;
import com.gmt.gmtUser.service.MapService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MapController {

    @Autowired
    MapService mapService;

    @GetMapping("/geocode")
    public ApiRequestResponse geocodeAddress(@RequestParam String address) throws JsonProcessingException {
        return new ApiRequestResponse(mapService.callGeoCodingApi(address));
    }
    @GetMapping("/place/textSearch")
    public ApiRequestResponse placetextSearchApi(@RequestParam String longitude, String latitude) throws JsonProcessingException {
        return new ApiRequestResponse(mapService.callPlacetextSearchApi(longitude, latitude));
    }
    @GetMapping("/directions")
    public DirectionsResult getDirections(@RequestParam String origin,
                                          @RequestParam String destination,
                                          @RequestParam(required = false, defaultValue = "DRIVING") String mode) {
        try {
            TravelMode travelMode = TravelMode.valueOf(mode.toUpperCase()); // Convert string to TravelMode
            return mapService.getDirections(origin, destination, travelMode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiRequestException("error while getting direction, error - "+ e.getMessage());
        }
    }
    @GetMapping("/placeDetails")
    public PlaceDetails getPlaceDetails(@RequestParam String placeId) {
        try {
            return mapService.getPlaceDetails(placeId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiRequestException("error while place details, error - "+ e.getMessage());
        }
    }
}
