package com.gmt.gmtUser.model.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PopularityResponse {
    private String location;
    private double popularityPercentage;

    // Constructors, getters, and setters
}
