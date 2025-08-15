package com.trieasenew.tripeasenew.controller;

import com.trieasenew.tripeasenew.dtos.request.CustomerRequest;
import com.trieasenew.tripeasenew.dtos.response.CustomerResponse;
import com.trieasenew.tripeasenew.enums.Gender;
import com.trieasenew.tripeasenew.model.Customer;
import com.trieasenew.tripeasenew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
            return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/getCustomerById")
    public CustomerResponse getCustomerByID(@RequestParam("id") int customerId)
    {
        return customerService.getCustomerById(customerId);
    }
    @GetMapping("/getAllByGender")
    public List<CustomerResponse> getAllByGender(@RequestParam("gender") Gender gender)
    {
        return customerService.getAllByGender(gender);
    }
    @GetMapping("/getAllByGenderAndAge")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender,@RequestParam("age") int age)
    {
        return customerService.getAllByGenderAndAge(gender,age);
    }
    @GetMapping("/getAllByGenderAndGreaterThanAge")
    public List<CustomerResponse> getAllByGenderAndGreaterThanAge(@RequestParam("gender") Gender gender,@RequestParam("age") int age)
    {
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
        return "Customer deleted successfully with ID: " + id;
    }
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }

}
