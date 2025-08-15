package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.CustomerRequest;
import com.trieasenew.tripeasenew.dtos.response.CustomerResponse;
import com.trieasenew.tripeasenew.enums.Gender;


import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age);

    void deleteCustomerById(int id);

    CustomerResponse updateCustomer(int id, CustomerRequest customerRequest);

    List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age);

    List<CustomerResponse> getAllByGender(Gender gender);

    CustomerResponse getCustomerById(int customerId);

    CustomerResponse addCustomer(CustomerRequest customerRequest);
}
