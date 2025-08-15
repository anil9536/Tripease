package com.trieasenew.tripeasenew.controller;


import com.trieasenew.tripeasenew.dtos.request.DriverRequest;
import com.trieasenew.tripeasenew.dtos.response.DriverResponse;
import com.trieasenew.tripeasenew.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {


    @Autowired
    DriverService driverService;

    @PostMapping("/addDriver")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest) {
        return driverService.addDriver(driverRequest);
    }

    @GetMapping("/getDriverById/{id}")
    public DriverResponse getDriverById(@PathVariable("id") int id)
    {
        return driverService.getDriverById(id);
    }

    @GetMapping("/getAllDriver")
    public List<DriverResponse> getAllDriver()
    {
        return driverService.getAllDriver();
    }

    @GetMapping("/getDriverAgeGreaterThan")
    public List<DriverResponse> getDriverGreaterThan(@RequestParam("age") int age)
    {
        return driverService.getDriverGreaterThan(age);
    }

    // Delete driver by ID
    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable int id) {
        driverService.deleteDriverById(id);
        return "Driver deleted successfully with ID: " + id;
    }

    // Update driver by ID
    @PutMapping("/{id}")
    public DriverResponse updateDriver(@PathVariable int id, @RequestBody DriverRequest driverRequest) {
        return driverService.updateDriver(id, driverRequest);
    }

    @GetMapping()
    public ResponseEntity<> getDriverCollection(@RequestParam()int driverId,@RequestParam() String date)
    {
        return driverService.getDriverCollection(driverId,date);
    }
}
