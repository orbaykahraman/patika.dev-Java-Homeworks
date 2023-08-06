package com.orbay.erpaccountingsystem.dto;


import com.orbay.erpaccountingsystem.model.Bill;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private Long id;
    private CustomerDto customer;
    private double totalPrice;
    private String orderStatus;


    public BillDto billToDto(Bill bill) {
        BillDto billDto = new BillDto();
        CustomerDto customerDto = new CustomerDto();
        OrderItemDto orderItemDto = new OrderItemDto();
        billDto.setCustomer(customerDto.customerToDto(bill.getCustomer()));
        billDto.setId(bill.getId());
        billDto.setOrderStatus(bill.getCustomer().getCustomerOrder().getOrderStatus());
        billDto.setTotalPrice(bill.getTotalPrice());
        return billDto;
    }

    public List<BillDto> billListToDtoList(List<Bill> billList) {
        List<BillDto> billDtoList = new ArrayList<>();
        for(Bill bill : billList) {
            BillDto billDto = new BillDto();
            CustomerDto customerDto = new CustomerDto();
            OrderItemDto orderItemDto = new OrderItemDto();
            billDto.setCustomer(customerDto.customerToDto(bill.getCustomer()));
            billDto.setId(bill.getId());
            billDto.setOrderStatus(bill.getCustomer().getCustomerOrder().getOrderStatus());
            billDto.setTotalPrice(bill.getCustomer().getCustomerOrder().getTotalAmount());
            billDtoList.add(billDto);
        }
        return billDtoList;
    }
}
