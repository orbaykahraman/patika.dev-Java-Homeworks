package com.orbay.erpaccountingsystem.service;

import com.orbay.erpaccountingsystem.dto.CustomerOrderDto;
import com.orbay.erpaccountingsystem.model.Customer;
import com.orbay.erpaccountingsystem.model.CustomerOrder;
import com.orbay.erpaccountingsystem.model.OrderItem;
import com.orbay.erpaccountingsystem.repository.CustomerOrderRepository;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderItemService orderItemService;

    CustomerOrderDto customerOrderDto = new CustomerOrderDto();

    public CustomerOrderDto findCustomerOrderDtoById(Long id) {
        if(customerOrderRepository.findById(id).isPresent()) {
            return customerOrderDto.customerOrderToDto(customerOrderRepository.findById(id).orElseThrow());
        }
        return null;
    }
    public CustomerOrder findCustomerOrderById(Long id) {
        if(customerOrderRepository.findById(id).isPresent()) {
            return customerOrderRepository.findById(id).get();
        }
        return null;
    }

    public CustomerOrderDto createNewCustomerOrder(Long customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setOrderStatus(OrderStatus.DEFAULT.getOrderValue());
        order.setCreationDate(new Date());
        customerOrderRepository.save(order);
        customerService.updateCustomerOrder(order,customerId);
        return customerOrderDto.customerOrderToDto(order);
    }

    public void createNewCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setCreationDate(new Date());
        customerOrderRepository.save(customerOrder);
    }


    public CustomerOrderDto addOrderItemToCustomerOrder(Long orderId, Long orderItemId) {
        if(customerOrderRepository.findById(orderId).isPresent()) {
            CustomerOrder customerOrder = customerOrderRepository.findById(orderId).orElseThrow();
            OrderItem orderItem = orderItemService.findById(orderItemId);
            List<OrderItem> orderItemList = customerOrder.getOrderItemList();
            orderItemList.add(orderItem);
            customerOrder.setOrderItemList(orderItemList);
            customerOrderDto.customerOrderToDto(customerOrderRepository.save(customerOrder));

        }
        return null;
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setUpdatedDate(new Date());
        customerOrderRepository.save(customerOrder);
    }
}
