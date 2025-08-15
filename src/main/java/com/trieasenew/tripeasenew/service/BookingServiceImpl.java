package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.BookingRequest;
import com.trieasenew.tripeasenew.dtos.response.BookingResponse;
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
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, int id)
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer not registerd");

        Customer customer = optionalCustomer.get();
        Cab availableCab = cabRepository.getAvailableCab();
        if(availableCab == null)
            throw new CabNotAvailable("Cab not Available");
        Booking booking = BookingTransformer.BookingRequestToBookingEntity(bookingRequest,availableCab.getPerKmRate());
        Booking savedBooking = bookingRepository.save(booking);
        availableCab.setCabAvailability(false);
        customer.getList().add(savedBooking);
        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBooking().add(savedBooking);

        Customer savedcustomer = customerRepository.save(customer);
        Driver saveddriver = driverRepository.save(driver);

        sendEmail(savedcustomer);

        return BookingTransformer.BookingEntityToBookingResponse(savedBooking,savedcustomer,availableCab,saveddriver);
    }
    private void sendEmail(Customer customer)
    {
        String text = "congrgulations Mr "+ customer.getName() +" your Cab has been booked enjoy the drive";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("anilpatel2017.9536@gmail.com");
        simpleMailMessage.setTo(customer.getEmail());
        simpleMailMessage.setSubject("anilpatel2017.9536@gmail.com");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
