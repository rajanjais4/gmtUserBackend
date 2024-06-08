package com.gmt.gmtUser.model.itinerary;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class POIVisitDetails {
    @NotNull
    private Date startDateTime;
    @NotNull
    private Date endDateTime;

    private String pointsOfInterestId;
}
