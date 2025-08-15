package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.CabRequest;
import com.trieasenew.tripeasenew.dtos.response.CabResponse;
import com.trieasenew.tripeasenew.exception.DriverNotFoundException;
import com.trieasenew.tripeasenew.model.Cab;
import com.trieasenew.tripeasenew.model.Driver;
import com.trieasenew.tripeasenew.repository.CabRepository;
import com.trieasenew.tripeasenew.repository.DriverRepository;
import com.trieasenew.tripeasenew.transformers.CabTransormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CabServiceImplementation implements CabService
{

    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;
    public CabResponse registerCab(CabRequest cabRequest, int driverid)
    {
        Optional<Driver> optionalDriver = driverRepository.findById(driverid);
        if(optionalDriver.isEmpty())
            throw new DriverNotFoundException("Driver Not Found  Exception");

        Driver driver = optionalDriver.get();

        Cab cab = CabTransormer.cabRequestToCabEntity(cabRequest);

        driver.setCab(cab);

        Driver savedDriver =driverRepository.save(driver); // it will save both ca and driver
        return CabTransormer.cabEntityToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
