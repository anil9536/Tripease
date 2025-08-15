package com.trieasenew.tripeasenew.transformers;

import com.trieasenew.tripeasenew.dtos.request.CustomerRequest;
import com.trieasenew.tripeasenew.dtos.response.CustomerResponse;
import com.trieasenew.tripeasenew.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestTocustomerEntityConversion(CustomerRequest customerRequest)
    {
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setGender(customerRequest.getGender());

        //orrr efficient way is builder

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerEntityToCustomerResponseConversion(Customer customer)
    {
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setAge(customer.getAge());
//        customerResponse.setEmail(customer.getEmail());
//
//        return customerResponse;

        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .build();
    }
}
