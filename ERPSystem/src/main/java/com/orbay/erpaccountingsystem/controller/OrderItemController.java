package com.orbay.erpaccountingsystem.controller;

import com.orbay.erpaccountingsystem.dto.OrderItemDto;
import com.orbay.erpaccountingsystem.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orbay.erpaccountingsystem.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
   OrderItemService orderItemService;

    @PostMapping("/{customerId}")
    public ResponseEntity<OrderItemDto> createNewOrderItem(@RequestBody OrderItem orderItem, @PathVariable(name = "customerId") Long customerId) {
        OrderItemDto dto = orderItemService.createNewOrderItem(orderItem,customerId);

        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable(name = "id") Long id) {
        OrderItemDto dto = orderItemService.findOrderItemDtoById(id);
        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @GetMapping("/findByOrderName/{customerOrderName}")
    public ResponseEntity<List<OrderItemDto>> findAllOrderItemsByCustomerOrderName(@PathVariable(name = "customerOrderName") String customerOrderName) {
        return new ResponseEntity<>(orderItemService.findAllOrderItemsByCustomerOrderName(customerOrderName),HttpStatus.OK);
    }
}
