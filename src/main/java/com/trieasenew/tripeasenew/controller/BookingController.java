package com.trieasenew.tripeasenew.controller;


import com.trieasenew.tripeasenew.dtos.request.BookingRequest;
import com.trieasenew.tripeasenew.dtos.response.BookingResponse;
import com.trieasenew.tripeasenew.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController
{
    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest, @RequestParam("customerId") int id)
    {
        return bookingService.bookCab(bookingRequest,id);
    }
}
