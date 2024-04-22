package com.gmt.gmtUser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gmt.gmtUser.exception.ApiRequestException;
import com.gmt.gmtUser.exception.ApiRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
public class MapService {
    @Autowired
    GenricExternalApiCallService genricExternalApiCallService;
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
}
