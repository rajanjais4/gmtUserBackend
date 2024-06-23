package com.gmt.gmtUser.model.Response;

import com.sun.tools.javac.Main;
import lombok.Data;

import java.util.List;

@Data
public class WeatherApiResponse {
    private List<WeatherData> list;

    // Getters and setters
    @Data

    public static class WeatherData {
        private Main main;

        public double getTemperature() {
            return  0;
        }

        // Getters and setters
    }
}

