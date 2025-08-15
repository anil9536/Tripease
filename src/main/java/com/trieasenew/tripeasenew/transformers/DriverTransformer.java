package com.trieasenew.tripeasenew.transformers;

import com.trieasenew.tripeasenew.dtos.request.DriverRequest;
import com.trieasenew.tripeasenew.dtos.response.DriverResponse;
import com.trieasenew.tripeasenew.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriverEntity(DriverRequest driverRequest)
    {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .email(driverRequest.getEmail())
                .build();
    }
    public static DriverResponse driverEntityToDriverResponse(Driver driver1)
    {
        return DriverResponse.builder()
                .age(driver1.getAge())
                .name(driver1.getName())
                .email(driver1.getEmail())
                .build();
    }
}
