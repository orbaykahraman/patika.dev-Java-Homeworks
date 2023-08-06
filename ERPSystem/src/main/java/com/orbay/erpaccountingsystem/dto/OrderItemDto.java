package com.orbay.erpaccountingsystem.dto;

import com.orbay.erpaccountingsystem.model.OrderItem;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private String name;
    private Long productId;
    private Long customerOrderId;
    private int quantity;


    public OrderItemDto orderItemToDto(OrderItem orderItem) {
        OrderItemDto dto = new OrderItemDto();
        dto.setCustomerOrderId(orderItem.getCustomerOrder().getId());
        dto.setId(orderItem.getId());
        dto.setName(orderItem.getName());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setQuantity(orderItem.getQuantity());
        return dto;
    }

    public List<OrderItemDto> orderItemListToDto(List<OrderItem> orderItemList) {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItem orderItem : orderItemList) {
            OrderItemDto dto = new OrderItemDto();
            dto.setCustomerOrderId(orderItem.getCustomerOrder().getId());
            dto.setId(orderItem.getId());
            dto.setName(orderItem.getName());
            dto.setProductId(orderItem.getProduct().getId());
            dto.setQuantity(orderItem.getQuantity());

            orderItemDtos.add(dto);
        }
        return orderItemDtos;
    }
}
