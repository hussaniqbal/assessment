package com.etiqa.assessment.controller;

import com.etiqa.assessment.model.Customer;
import com.etiqa.assessment.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.etiqa.assessment.config.Constants.HttpCodes.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Get all customers")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiOperation(value = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @ApiOperation(value = "Create new customer")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @ApiOperation(value = "Update customer by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer toUpdateCustomer) {
        Customer updatedCustomer = customerService.updateCustomer(id, toUpdateCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @ApiOperation(value = "Delete customer by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
