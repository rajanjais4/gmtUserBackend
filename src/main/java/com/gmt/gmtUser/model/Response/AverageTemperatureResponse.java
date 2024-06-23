package com.gmt.gmtUser.model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageTemperatureResponse {
    private String location;
    private double averageTemperature;

    // Constructors, getters, and setters
}

