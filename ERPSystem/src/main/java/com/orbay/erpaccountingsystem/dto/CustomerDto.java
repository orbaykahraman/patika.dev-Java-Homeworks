package com.orbay.erpaccountingsystem.dto;

import com.orbay.erpaccountingsystem.model.Bill;
import com.orbay.erpaccountingsystem.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private Long customerOrderId;
    private List<Bill> bills;

    public CustomerDto customerToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerOrderId(customer.getCustomerOrder().getId());
        customerDto.setId(customer.getId());
        List<Bill> bills = new ArrayList<Bill>();
        bills = customerDto.getBills();
        if(bills != null) {
            customerDto.setBills(bills);
        }
        customerDto.setName(customer.getName());
        return customerDto;
    }

    public List<CustomerDto> customerListToDto(List<Customer> customers) {
        List<CustomerDto> customersDto = new ArrayList<>();
        for(Customer customer:customers) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomerOrderId(customer.getCustomerOrder().getId());
            customerDto.setId(customer.getId());
            List<Bill> bills = new ArrayList<Bill>();
            bills = customerDto.getBills();
            if(bills != null) {
                customerDto.setBills(bills);
            }
            customerDto.setName(customer.getName());
            customersDto.add(customerDto);
        }
        return customersDto;
    }
}
