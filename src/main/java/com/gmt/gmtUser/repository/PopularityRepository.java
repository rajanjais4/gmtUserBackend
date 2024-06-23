package com.gmt.gmtUser.repository;

import com.gmt.gmtUser.model.Response.PopularityResponse;
import com.gmt.gmtUser.service.InternalAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PopularityRepository {

    // Assuming we have some internal analytics service to fetch the booking data
    @Autowired
    private InternalAnalyticsService internalAnalyticsService;

    public PopularityResponse calculatePopularity(String location) {
        int bookings = internalAnalyticsService.getBookingsForLocation(location);
        double totalBookings = internalAnalyticsService.getTotalBookings();
        double popularityPercentage = (bookings / totalBookings) * 100;

        // Optionally, we could integrate Google Trends API here for more data

        return new PopularityResponse(location, popularityPercentage);
    }
}
