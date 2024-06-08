package com.gmt.gmtUser.model.booking;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;

@Data
@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;

    @NotBlank
    private String userId;

    @NotBlank
    private String itineraryId;

    private String type;
    private BookingDetails bookingDetails;
    private Date createdAt;
    private Date updatedAt;
}
