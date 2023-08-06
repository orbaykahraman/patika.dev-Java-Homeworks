package com.orbay.erpaccountingsystem.dto;

import com.orbay.erpaccountingsystem.model.CustomerOrder;
import com.orbay.erpaccountingsystem.model.OrderItem;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDto {

    private Long id;
    private String name;
    private Date creationDate;
    private Date updatedDate;
    private Long customerId;
    private String orderStatus;
    private double totalAmount;

    public CustomerOrderDto customerOrderToDto(CustomerOrder customerOrder){
        CustomerOrderDto dto = new CustomerOrderDto();
        dto.setCustomerId(customerOrder.getCustomer().getId());
        dto.setId(customerOrder.getId());
        dto.setName(customerOrder.getName());
        dto.setCreationDate(customerOrder.getCreationDate());
        dto.setUpdatedDate(customerOrder.getUpdatedDate());
        dto.setTotalAmount(customerOrder.getTotalAmount());
        dto.setOrderStatus(customerOrder.getOrderStatus());
        return dto;

    }
}
