package com.gmt.gmtUser.model.booking;
import lombok.Data;
import java.util.Date;

@Data
public class BookingDetails {
    private String provider;
    private String confirmationNumber;
    private Date startDate;
    private Date endDate;
    private Double price;
}