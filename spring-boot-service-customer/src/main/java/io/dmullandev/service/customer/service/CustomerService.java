package io.dmullandev.service.customer.service;

import org.springframework.stereotype.Service;
import io.dmullandev.service.customer.model.Customer;
import io.dmullandev.service.customer.model.CustomerRegistrationRequest;
import io.dmullandev.service.customer.repository.CustomerRepository;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                                    .firstName(request.firstName())
                                    .lastName(request.lastName())
                                    .email(request.email())
                                    .build();

        customerRepository.save(customer);
    }

}
