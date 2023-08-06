package com.orbay.erpaccountingsystem.service;

import com.orbay.erpaccountingsystem.dto.OrderItemDto;
import com.orbay.erpaccountingsystem.model.Customer;
import com.orbay.erpaccountingsystem.model.CustomerOrder;
import com.orbay.erpaccountingsystem.model.OrderItem;
import com.orbay.erpaccountingsystem.model.Product;
import com.orbay.erpaccountingsystem.repository.OrderItemRepository;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerOrderService customerOrderService;
    @Autowired
    CustomerService customerService;

    OrderItemDto dto = new OrderItemDto();

    @Transactional
    public OrderItemDto createNewOrderItem(OrderItem orderItem, Long customerId) {
        Product product = productService.findProductById(orderItem.getProduct().getId());
        Customer customer = customerService.findCustomerById(customerId);
        if(orderItem.getQuantity() > product.getStock()) {
            return null;
        }
        orderItem.setCustomerOrder(customer.getCustomerOrder());
        List<OrderItem> orderItems = customer.getCustomerOrder().getOrderItemList();
        orderItems.add(orderItem);

        CustomerOrder customerOrder = customerOrderService.findCustomerOrderById(customer.getCustomerOrder().getId());
        customerOrder.setOrderItemList(orderItems);
        customerOrder.setTotalAmount(customerOrder.getTotalAmount() + (product.getPrice()*(orderItem.getQuantity())));
        orderItem.setProduct(product);
        orderItem.setCreationDate(new Date());
        productService.updateStockAfterOrderItem(orderItem.getQuantity(),product);
        customerService.updateCustomer(customer);
        customerOrderService.updateCustomerOrder(customerOrder);
        return dto.orderItemToDto(orderItemRepository.save(orderItem));
    }

    public OrderItemDto findOrderItemDtoById(Long id) {
        if(orderItemRepository.findById(id).isPresent()) {
            return dto.orderItemToDto(orderItemRepository.findById(id).orElseThrow());
        }
        return null;
    }

    public OrderItem findById(Long id) {
        if(orderItemRepository.findById(id).isPresent()) {
            return orderItemRepository.findById(id).orElseThrow();
        }
        return null;
    }

    public List<OrderItemDto> findAllOrderItemsByCustomerOrderName(String customerOrderName) {
        return dto.orderItemListToDto(orderItemRepository.findAllByCustomerOrderName(customerOrderName));
    }
}
