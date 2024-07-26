package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.Customer;
import edu.icet.demo.entity.CustomerEntity;
import edu.icet.demo.repository.CustomerRepository;
import edu.icet.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ObjectMapper mapper;

    @Override
    public Boolean addCustomer(Customer customer) {
        Boolean isSaved = false;
        CustomerEntity customerEntity = null;
        try {
            customerEntity = mapper.convertValue(customer, CustomerEntity.class);
            repository.save(customerEntity);
            isSaved = true;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }

    @Override
    public List<Customer> getAll() {
        List<CustomerEntity> customerEntityList = repository.findAll();
        List<Customer> customerList = new ArrayList<>();

        customerEntityList.forEach(customerEntity ->
                customerList.add(
                        mapper.convertValue(customerEntity, Customer.class)
                ));
        return customerList;
    }

    @Override
    public Boolean deleteCustomerById(Long id) {
        Boolean isDeleted = false;
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                isDeleted = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        Boolean isUpdated = false;
        try {
            if (repository.findById(customer.getCustomerId()).isPresent()){
                repository.save(mapper.convertValue(customer, CustomerEntity.class)
                );
                isUpdated = true;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public Customer findById(Long id) {
        return mapper.convertValue(repository.findById(id), Customer.class);
    }
}
