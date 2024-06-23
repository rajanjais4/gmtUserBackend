package com.gmt.gmtUser.repository;

import com.gmt.gmtUser.model.Response.AverageTemperatureResponse;
import com.gmt.gmtUser.model.Response.WeatherApiResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WeatherRepository {

    private static final String API_KEY = "YOUR_OPENWEATHERMAP_API_KEY";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    public AverageTemperatureResponse fetchAverageWeekTemperature(String location) {
        String url = BASE_URL + "?q=" + location + "&appid=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        WeatherApiResponse apiResponse = restTemplate.getForObject(url, WeatherApiResponse.class);

        // Calculate the average temperature for the week
        double averageTemperature = apiResponse.getList().stream()
                .mapToDouble(WeatherApiResponse.WeatherData::getTemperature)
                .average()
                .orElse(Double.NaN);

        return new AverageTemperatureResponse(location, averageTemperature);
    }
}