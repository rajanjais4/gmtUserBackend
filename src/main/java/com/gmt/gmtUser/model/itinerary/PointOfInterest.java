package com.gmt.gmtUser.model.itinerary;


import com.gmt.gmtUser.model.common.Location;
import com.gmt.gmtUser.model.common.TagScore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "pointsOfInterest")
public class PointOfInterest {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String placeId; // Reference to Place

    @NotNull
    private Location location;

    private List<TagScore> tagsScore;

    private String description;

    private Integer popularity; // Percentage or score

    private Date openTime;

    private Date closeTime;

    private Date createdAt;

    private Date updatedAt;
}
