package com.orbay.erpaccountingsystem.controller;

import com.orbay.erpaccountingsystem.dto.CustomerDto;
import com.orbay.erpaccountingsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import com.orbay.erpaccountingsystem.model.Bill;
import com.orbay.erpaccountingsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orbay.erpaccountingsystem.service.CustomerOrderService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createNewCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findCustomerDtoById(id),HttpStatus.OK);
    }

}
