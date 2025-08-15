package com.trieasenew.tripeasenew.transformers;

import com.trieasenew.tripeasenew.dtos.request.BookingRequest;
import com.trieasenew.tripeasenew.dtos.request.CabRequest;
import com.trieasenew.tripeasenew.dtos.response.BookingResponse;
import com.trieasenew.tripeasenew.dtos.response.CabResponse;
import com.trieasenew.tripeasenew.enums.TripStatus;
import com.trieasenew.tripeasenew.model.Booking;
import com.trieasenew.tripeasenew.model.Cab;
import com.trieasenew.tripeasenew.model.Customer;
import com.trieasenew.tripeasenew.model.Driver;

public class BookingTransformer
{
    public static Booking BookingRequestToBookingEntity(BookingRequest bookingRequest,double perkmRate)
    {
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistance(bookingRequest.getTripDistance())
                .tripStatus(TripStatus.INPROGRESS)
                .billAmount(bookingRequest.getTripDistance()*perkmRate)
                .build();
    }
    public static BookingResponse BookingEntityToBookingResponse(Booking book, Customer customer,Cab cab,Driver driver)
    {
        return BookingResponse.builder()
                .pickup(book.getPickup())
                .destination(book.getDestination())
                .tripDistance(book.getTripDistance())
                .tripStatus(book.getTripStatus())
                .billAmount(book.getBillAmount())
                .bookedAt(book.getBookedAt())
                .lastUpdateTimeStamp(book.getLastUpdateTimeStamp())
                .customerResponse(CustomerTransformer.customerEntityToCustomerResponseConversion(customer))
                .cabResponse(CabTransormer.cabEntityToCabResponse(cab,driver))
                .build();
    }
}
