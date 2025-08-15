package com.trieasenew.tripeasenew.dtos.response;

import com.trieasenew.tripeasenew.enums.TripStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {
    private String pickup;
    private String destination;
    private double tripDistance;
    private TripStatus tripStatus ;
    private double billAmount;
    Date bookedAt;
    Date lastUpdateTimeStamp;
    private CustomerResponse customerResponse;
    private CabResponse cabResponse;

}
