package edu.icet.demo.service;

import edu.icet.demo.dto.Customer;

import java.util.List;

public interface CustomerService {
    Boolean addCustomer(Customer customer);

    List<Customer> getAll();

    Boolean deleteCustomerById(Long id);

    Boolean updateCustomer(Customer customer);

    Customer findById(Long id);
}
