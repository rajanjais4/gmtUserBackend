package com.gmt.gmtUser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmt.gmtUser.exception.ApiRequestException;
import com.gmt.gmtUser.exception.ApiRequestResponse;
import com.gmt.gmtUser.service.MapService;
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

}
