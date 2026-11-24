package com.bank.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * The service contract (like a TypeScript interface): it lists WHAT can be done,
 * not HOW. The logic lives in CustomerServiceImpl, which has the @Service annotation.
 * Do not put @Service or fields on an interface; Spring ignores them.
 * The imports above for Autowired and Service are no longer used and can be removed.
 */
public interface CustomerService {

    // Insert a new customer and return it with its generated id
    Customer createCustomer(Customer customerDetails);

    // Return all customers
    List<Customer> getAllCustomers();

    // Return one customer, or an empty Optional if the id doesn't exist
    Optional<Customer> getCustomerById(Long customerId);

    // Replace the customer with this id using the given details
    String updateCustomer(Long customerId, Customer customerDetails);

    // Delete the customer with this id
    String deleteCustomer(Long customerId);
}
