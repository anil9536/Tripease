package com.trieasenew.tripeasenew.controller;


import com.trieasenew.tripeasenew.dtos.request.CabRequest;
import com.trieasenew.tripeasenew.dtos.response.CabResponse;
import com.trieasenew.tripeasenew.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")

public class CabController {

    @Autowired
    CabService cabService;
    @PostMapping("/registerCab/{driverid}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest, @PathVariable("driverid") int id)
    {
        return cabService.registerCab(cabRequest,id);
    }
}
