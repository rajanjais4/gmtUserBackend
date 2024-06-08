package com.gmt.gmtUser.model.itinerary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "itineraries")
public class Itinerary {
    @Id
    private String id;

    @NotBlank
    private String userId; // Reference to User

    @NotBlank
    private String placeId; // Reference to Place

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    private Integer totalDistanceInMeter;

    private List<String> eachDayItinerary; // List of Day Itinerary IDs

    private List<String> bookingIds; // List of Booking IDs

    private Date createdAt;

    private Date updatedAt;
}
