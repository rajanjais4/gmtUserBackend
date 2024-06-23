package com.gmt.gmtUser.controller;

import com.gmt.gmtUser.service.GooglePlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private GooglePlacesService googlePlacesService;

    @GetMapping("/autocomplete")
    public String autocomplete(@RequestParam String input,
                               @RequestParam(required = false) Double lat,
                               @RequestParam(required = false) Double lng,
                               @RequestParam(required = false) String country) {
        return googlePlacesService.getPlacePredictions(input, lat, lng, country);
    }
}
