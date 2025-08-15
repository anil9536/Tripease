package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.CustomerRequest;
import com.trieasenew.tripeasenew.dtos.response.CustomerResponse;
import com.trieasenew.tripeasenew.enums.Gender;
import com.trieasenew.tripeasenew.exception.CustomerNotFoundException;
import com.trieasenew.tripeasenew.model.Customer;
import com.trieasenew.tripeasenew.repository.CustomerRepository;
import com.trieasenew.tripeasenew.transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        Customer customer = CustomerTransformer.customerRequestTocustomerEntityConversion(customerRequest);
        Customer customer1 = customerRepository.save(customer);
        return CustomerTransformer.customerEntityToCustomerResponseConversion(customer1);
    }

    public CustomerResponse getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Invalid customer Id");

        Customer customer = optionalCustomer.get();
        return CustomerTransformer.customerEntityToCustomerResponseConversion(customer);
    }

    public List<CustomerResponse> getAllByGender(Gender gender)
    {
        List<Customer> customerList = customerRepository.findByGender(gender);


        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customerList)
        {
            customerResponses.add(CustomerTransformer.customerEntityToCustomerResponseConversion(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age)
    {
        List<Customer> customerList = customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customerList)
        {
            customerResponses.add(CustomerTransformer.customerEntityToCustomerResponseConversion(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age)
    {
        List<Customer> customerList = customerRepository.findByGenderAndGreaterThanAge(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customerList)
        {
            customerResponses.add(CustomerTransformer.customerEntityToCustomerResponseConversion(customer));
        }
        return customerResponses;
    }

    public void deleteCustomerById(int id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    public CustomerResponse updateCustomer(int id, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
        existingCustomer.setName(customerRequest.getName());
        existingCustomer.setEmail(customerRequest.getEmail());
        existingCustomer.setGender(customerRequest.getGender());
        existingCustomer.setAge(customerRequest.getAge());

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerTransformer.customerEntityToCustomerResponseConversion(updatedCustomer);
    }

}
