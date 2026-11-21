package com.bank.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
 * @Service marks this class as a Spring bean (like @Injectable() in Angular).
 * Without it Spring never creates it, so the controller gets nothing injected
 * and customerService stays null (that caused the NullPointerException earlier).
 *
 * CustomerService is an interface (the contract); this class is the implementation.
 * The controller only knows about the interface, so the implementation can be swapped later.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    // Field injection: Spring sets this after creating the object.
    // It must NOT be 'final' (final fields can only be set in a constructor).
    // CustomerRepository is a JpaRepository interface; Spring generates the SQL code for it.
    @Autowired
    CustomerRepository customerRepository;

    // CREATE: save() runs INSERT because the id is null (DB generates it, IDENTITY).
    // Returns the saved row including its new id.
    // A duplicate email throws DataIntegrityViolationException (unique constraint).
    @Override
    public Customer createCustomer(Customer customerDetails) {
        return customerRepository.save(customerDetails);
//        return "Customer Details Saved";
    }

    // READ ALL: findAll() runs SELECT * FROM customer and returns every row as a list.
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // READ ONE: findById() returns Optional, which is either the customer or empty.
    // Optional avoids returning null when the id doesn't exist (like T | undefined in TS).
    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    // UPDATE:
    // 1. findById + orElseThrow: check the customer exists, else respond with HTTP 404.
    // 2. Set the id from the URL onto the incoming body, so the body can't target a different row.
    // 3. save() sees a non-null id, so it runs UPDATE instead of INSERT.
    // Note: this REPLACES all fields with the request body. Fields missing from the body become null.
    // Note: customerData is only used for the existence check here.
    @Override
    public String updateCustomer(Long customerId,Customer customerDetails) {
        Customer customerData = customerRepository.findById(customerId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with "+customerId+" Not Found"));
        customerDetails.setId(customerId);
        customerRepository.save(customerDetails);
        return "Customer with "+customerId+" Updated";
    }

    // DELETE:
    // 1. Load the customer, or respond with HTTP 404 if the id doesn't exist.
    // 2. delete() removes the row (DELETE FROM customer WHERE id = ?).
    @Override
    public String deleteCustomer(Long customerId) {
        Customer customerData=customerRepository.findById(customerId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with "+customerId+" Not Found"));
        customerRepository.delete(customerData);
        return "Customer with "+customerId+" Deleted";
    }
}
