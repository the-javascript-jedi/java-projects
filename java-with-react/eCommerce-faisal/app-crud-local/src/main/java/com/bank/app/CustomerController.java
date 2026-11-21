package com.bank.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @RestController: this class handles HTTP requests and returns JSON (like an Express router).
 * @RequestMapping: every endpoint below starts with /api/customers.
 * Full URLs, e.g. GET http://localhost:8080/api/customers/getAllCustomers
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    // Constructor injection: Spring passes in the CustomerService bean (CustomerServiceImpl).
    // Keep only ONE constructor. With two, Spring used the empty one, so
    // customerService stayed null and the NullPointerException happened.
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    // Empty constructor removed on purpose (see above).
    // public CustomerController(){

    // }

    // POST /api/customers/createCustomer
    // @RequestBody converts the JSON in the request into a Customer object.
    // Returns the saved customer (with its generated id).
    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerDetails){
        return ResponseEntity.ok(customerService.createCustomer(customerDetails));
    }

    // GET /api/customers/getAllCustomers
    // Returns all customers as a JSON array.
    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // DELETE /api/customers/deleteCustomer (no id)
    // Placeholder: it does nothing and returns an empty 200.
    // The working delete is the {customerId} version below.
    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(){
        return ResponseEntity.ok("");
    }

    // PUT /api/customers/updateCustomer/5
    // @PathVariable reads the id from the URL; @RequestBody reads the new data from the JSON body.
    // If the id doesn't exist, the service throws and the client gets a 404.
    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customerDetails,@PathVariable Long customerId){
        customerService.updateCustomer(customerId,customerDetails);
        return ResponseEntity.ok("Succesfully updated "+customerId);
    }

    // DELETE /api/customers/deleteCustomer/5
    // Deletes the customer with that id; 404 if it doesn't exist.
    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Succesfully deleted "+customerId);
    }

}
