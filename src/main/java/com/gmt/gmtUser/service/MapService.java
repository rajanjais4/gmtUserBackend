package com.gmt.gmtUser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gmt.gmtUser.exception.ApiRequestException;
import com.gmt.gmtUser.exception.ApiRequestResponse;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

@Service
public class MapService {
    @Autowired
    GenricExternalApiCallService genricExternalApiCallService;

    @Autowired
    private GeoApiContext geoApiContext;
    @Value("${google.geocoding.api.key}")
    private String apiKey;
     public JsonNode callGeoCodingApi(String address ) throws JsonProcessingException {
         try {
             String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;
             return genricExternalApiCallService.getApiResponseBody(url);
         }
         catch (Exception ex){
             throw new ApiRequestException(" Error while fetching geo code api, "+ ex.getMessage());
         }
    }
    public JsonNode callPlacetextSearchApi(String longitude, String latitude ) throws JsonProcessingException {
        try {
            String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=point+of+interest"+
                        "&location="+ longitude +","+latitude+
                        "&rankBy=rating"+
                        "&key=" + apiKey;
            return genricExternalApiCallService.getApiResponseBody(url);
        }
        catch (Exception ex){
            throw new ApiRequestException(" Error while fetching geo code api, "+ ex.getMessage());
        }
    }


    public DirectionsResult getDirections(String origin, String destination,TravelMode mode ) throws InterruptedException, IOException, ApiException {
        return DirectionsApi.newRequest(geoApiContext)
                .mode(mode)
                .origin(origin)
                .destination(destination)
                .await();
    }

    public PlaceDetails getPlaceDetails(String placeId) throws InterruptedException, ApiException, IOException {
        return PlacesApi.placeDetails(geoApiContext, placeId).await();
    }
}
