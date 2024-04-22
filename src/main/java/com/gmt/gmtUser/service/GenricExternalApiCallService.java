package com.gmt.gmtUser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmt.gmtUser.exception.ApiRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenricExternalApiCallService {
     JsonNode getApiResponseBody(String url) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String jsonResponse = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseBodyJson = objectMapper.readTree(jsonResponse);

        if( response == null || !response.getStatusCode().is2xxSuccessful())
            throw new ApiRequestException("error:"+responseBodyJson);
        return responseBodyJson;

    }
}
