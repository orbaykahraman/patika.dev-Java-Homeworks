package com.orbay.erpaccountingsystem.controller;

import com.orbay.erpaccountingsystem.dto.CustomerOrderDto;
import com.orbay.erpaccountingsystem.model.CustomerOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orbay.erpaccountingsystem.service.CustomerOrderService;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrderDto> findCustomerOrderById(@PathVariable("id")Long id) {
        CustomerOrderDto customerOrderDto = customerOrderService.findCustomerOrderDtoById(id);

        if (customerOrderDto == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOrderDto,HttpStatus.OK);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<CustomerOrderDto> createCustomerOrderByCustomerId(@PathVariable(name = "customerId") Long customerId) {
        return new ResponseEntity<>(customerOrderService.createNewCustomerOrder(customerId),HttpStatus.OK);
    }

    @PutMapping("/{orderId}/{orderItemId}")
    public ResponseEntity<CustomerOrderDto> addOrderItemToCustomerOrder(@PathVariable(name = "orderId") Long orderId, @PathVariable("orderItemId") Long orderItemId) {
        CustomerOrderDto customerOrderDto = customerOrderService.addOrderItemToCustomerOrder(orderId,orderItemId);
        if(customerOrderDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOrderDto,HttpStatus.OK);
    }

}
