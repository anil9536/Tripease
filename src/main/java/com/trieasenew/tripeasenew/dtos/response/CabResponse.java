package com.trieasenew.tripeasenew.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabResponse
{
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean cabAvailability;
    private DriverResponse driverResponse;
}
