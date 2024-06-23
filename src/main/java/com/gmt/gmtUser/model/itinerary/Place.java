package com.gmt.gmtUser.model.itinerary;

import com.gmt.gmtUser.model.common.Location;
import com.gmt.gmtUser.model.common.TagScore;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "places")
public class Place {
    @Id
    private String id;

    @NotBlank
    private String name;

    private Location location;

    private String description;

    private List<String> images; // URLs to images

    private Integer popularity; // Percentage or score

    private List<TagScore> tagsScore;

    private List<String> poi; // List of POI IDs
    private String shortDescription;
    private Date createdAt;

    private Date updatedAt;
}
