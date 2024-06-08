package com.gmt.gmtUser.model.itinerary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "dayItineraries")
public class DayItinerary {
    @Id
    private String id;

    @NotBlank
    private String itineraryId;

    @NotNull
    private Date date;

    @NotNull
    private List<POIVisitDetails> POIVisitDetailsList;

    private String notes;
    private Date createdAt;
    private Date updatedAt;
}