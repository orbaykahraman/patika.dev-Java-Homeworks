package com.orbay.erpaccountingsystem.service;

import com.orbay.erpaccountingsystem.dto.CustomerDto;
import com.orbay.erpaccountingsystem.repository.CustomerRepository;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import com.orbay.erpaccountingsystem.model.Bill;
import com.orbay.erpaccountingsystem.model.Customer;
import com.orbay.erpaccountingsystem.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerOrderService customerOrderService;

    CustomerDto customerDto = new CustomerDto();
    public List<CustomerDto> findAllCustomers() {

        return customerDto.customerListToDto(customerRepository.findAll());
    }

    public CustomerDto createNewCustomer(Customer customer) {
        if(customer.getCustomerOrder() == null){
            CustomerOrder customerOrder = new CustomerOrder();
            customerOrder.setCustomer(customer);
            customerOrder.setName(customer.getName());
            customerOrder.setOrderStatus(OrderStatus.DEFAULT.getOrderValue());
            customer.setCustomerOrder(customerOrder);
            customer.setCreationDate(new Date());
            customerOrderService.createNewCustomerOrder(customerOrder);
        }
        return customerDto.customerToDto(customerRepository.save(customer));
    }

    public CustomerDto findCustomerDtoById(Long id) {
        return customerDto.customerToDto(customerRepository.findById(id).orElseThrow());
    }
    public Customer findCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow();
    }

    public void updateCustomerOrder(CustomerOrder order, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        customer.setCustomerOrder(order);
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        if(customerRepository.findById(customer.getId()).isPresent()) {
            customer.setUpdatedDate(new Date());
            customerRepository.save(customer);
        }
    }
}
