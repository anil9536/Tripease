package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.DriverRequest;
import com.trieasenew.tripeasenew.dtos.response.DriverResponse;
import com.trieasenew.tripeasenew.exception.DriverNotFoundException;
import com.trieasenew.tripeasenew.model.Cab;
import com.trieasenew.tripeasenew.model.Driver;
import com.trieasenew.tripeasenew.repository.CabRepository;
import com.trieasenew.tripeasenew.repository.DriverRepository;
import com.trieasenew.tripeasenew.transformers.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CabRepository cabRepository;

    public DriverResponse addDriver(DriverRequest driverRequest)
    {
        Driver driver = DriverTransformer.driverRequestToDriverEntity(driverRequest);
        Driver driver1 = driverRepository.save(driver);
        return DriverTransformer.driverEntityToDriverResponse(driver1);
    }

    public DriverResponse getDriverById(int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if(driver.isEmpty())
            throw new DriverNotFoundException("driver not found with this id");
        Driver driver1 = driver.get();
        return DriverTransformer.driverEntityToDriverResponse(driver1);

    }

    public List<DriverResponse> getAllDriver() {
        List<Driver> driverList = driverRepository.findAll();

        List<DriverResponse> driverResponseList = new ArrayList<>();
        for(Driver driver:driverList)
        {
            driverResponseList.add(DriverTransformer.driverEntityToDriverResponse(driver));
        }
        return driverResponseList;

    }

    public List<DriverResponse> getDriverGreaterThan(int age) {
        List<Driver> driverList = driverRepository.findByAge(age);

        List<DriverResponse> driverResponseList = new ArrayList<>();
        for(Driver driver:driverList)
        {
            driverResponseList.add(DriverTransformer.driverEntityToDriverResponse(driver));
        }
        return driverResponseList;
    }
    public void deleteDriverById(int id) {
        if (!driverRepository.existsById(id)) {
            throw new DriverNotFoundException("Driver not found with ID: " + id);
        }
        driverRepository.deleteById(id);
    }

    public DriverResponse updateDriver(int id, DriverRequest driverRequest) {
        Driver existingDriver = driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver not found with ID: " + id));

        // Update fields
        existingDriver.setName(driverRequest.getName());
        existingDriver.setEmail(driverRequest.getEmail());
        existingDriver.setAge(driverRequest.getAge());

        Driver updatedDriver = driverRepository.save(existingDriver);
        return DriverTransformer.driverEntityToDriverResponse(updatedDriver);
    }

    @Override
    public ResponseEntity getDriverCollection(int driverId, String date) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(()-> new DriverNotFoundException("driver Not Found "));
        Cab cab = driverRepository.getDriverByCabId(driver.getCab());
    }
}
