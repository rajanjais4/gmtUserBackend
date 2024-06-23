package com.gmt.gmtUser.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GooglePlacesService {

    @Value("${google.geocoding.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getPlacePredictions(String input, Double lat, Double lng, String country) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/place/autocomplete/json")
                .queryParam("input", input)
                .queryParam("key", apiKey);

        if (lat != null && lng != null) {
            uriBuilder.queryParam("location", lat + "," + lng)
                    .queryParam("radius", 50000);  // Adjust radius as needed
        }
        if (country != null && !country.isEmpty()) {
            uriBuilder.queryParam("components", "country:" + country);
        }

        String url = uriBuilder.toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
