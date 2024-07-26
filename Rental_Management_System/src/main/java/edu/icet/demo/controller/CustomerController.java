package edu.icet.demo.controller;

import edu.icet.demo.dto.Customer;
import edu.icet.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-controller")
public class CustomerController {

    final CustomerService service;

    @GetMapping("/get-all")
    public List<Customer> getAll(){
        return service.getAll();
    }

    @PostMapping("/add-customer")
    public Boolean addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable Long id){
        return service.deleteCustomerById(id);
    }
    @PutMapping("/update-customer")
    public Boolean updateEmployee(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }
    @GetMapping("/find-by-id/{id}")
    public Customer findById(@PathVariable Long id){
        return service.findById(id);
    }
}
