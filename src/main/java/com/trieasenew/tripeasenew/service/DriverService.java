package com.trieasenew.tripeasenew.service;
import com.trieasenew.tripeasenew.dtos.request.DriverRequest;
import com.trieasenew.tripeasenew.dtos.response.DriverResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DriverService {


    DriverResponse addDriver(DriverRequest driverRequest);

    List<DriverResponse> getAllDriver();

    List<DriverResponse> getDriverGreaterThan(int age);

    DriverResponse getDriverById(int id);

    void deleteDriverById(int id);

    DriverResponse updateDriver(int id, DriverRequest driverRequest);

    ResponseEntity getDriverCollection(int driverId, String date);
}
