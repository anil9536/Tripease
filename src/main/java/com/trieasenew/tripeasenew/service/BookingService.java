package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.BookingRequest;
import com.trieasenew.tripeasenew.dtos.response.BookingResponse;
import com.trieasenew.tripeasenew.dtos.response.CustomerResponse;
import com.trieasenew.tripeasenew.exception.CabNotAvailable;
import com.trieasenew.tripeasenew.exception.CustomerNotFoundException;
import com.trieasenew.tripeasenew.model.Booking;
import com.trieasenew.tripeasenew.model.Cab;
import com.trieasenew.tripeasenew.model.Customer;
import com.trieasenew.tripeasenew.model.Driver;
import com.trieasenew.tripeasenew.repository.BookingRepository;
import com.trieasenew.tripeasenew.repository.CabRepository;
import com.trieasenew.tripeasenew.repository.CustomerRepository;
import com.trieasenew.tripeasenew.repository.DriverRepository;
import com.trieasenew.tripeasenew.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookingService
{
    BookingResponse bookCab(BookingRequest bookingRequest, int id);
}
