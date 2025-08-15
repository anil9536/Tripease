package com.trieasenew.tripeasenew.transformers;

import com.trieasenew.tripeasenew.dtos.request.CabRequest;
import com.trieasenew.tripeasenew.dtos.request.DriverRequest;
import com.trieasenew.tripeasenew.dtos.response.CabResponse;
import com.trieasenew.tripeasenew.dtos.response.DriverResponse;
import com.trieasenew.tripeasenew.model.Cab;
import com.trieasenew.tripeasenew.model.Driver;

public class CabTransormer
{
    public static Cab cabRequestToCabEntity(CabRequest cabRequest)
    {
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .perKmRate(cabRequest.getPerKmRate())
                .cabAvailability(true)
                .build();
    }
    public static CabResponse cabEntityToCabResponse(Cab cab,Driver driver)
    {
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .perKmRate(cab.getPerKmRate())
                .cabAvailability(cab.isCabAvailability())
                .driverResponse(DriverTransformer.driverEntityToDriverResponse(driver))
                .build();
    }
}
