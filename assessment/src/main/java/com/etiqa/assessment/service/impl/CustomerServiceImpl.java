package com.etiqa.assessment.service.impl;

import com.etiqa.assessment.model.Customer;
import com.etiqa.assessment.repository.CustomerRepository;
import com.etiqa.assessment.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        logger.info("Fetching all customers");
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        logger.info("Fetching customer with id: {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        logger.info("Creating customer: {}", customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setFamilyMembers(updatedCustomer.getFamilyMembers());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        logger.info("Deleting customer with id: {}", id);
        customerRepository.deleteById(id);
    }
}
