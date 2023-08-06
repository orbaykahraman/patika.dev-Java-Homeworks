package com.orbay.erpaccountingsystem.dto;

import com.orbay.erpaccountingsystem.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String info;
    private double price;
    private int stock;
    private boolean isProductAvailable;
    private double taxAppliedPrice;
    private List<OrderItemDto> orderItems;

    public ProductDto productToDto(Product product) {
        OrderItemDto orderItemDto = new OrderItemDto();
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setInfo(product.getInfo());
        dto.setProductAvailable(product.isProductAvailable());
        dto.setPrice(product.getPrice());
        dto.setTaxAppliedPrice(product.getTaxAppliedPrice());
        dto.setStock(product.getStock());
        if(product.getOrderItemList() != null) {
            dto.setOrderItems(orderItemDto.orderItemListToDto(product.getOrderItemList()));
        }

        return dto;
    }

    public List<ProductDto> productListToDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        OrderItemDto orderItemDto = new OrderItemDto();
        for(Product product : productList){
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setInfo(product.getInfo());
            dto.setProductAvailable(product.isProductAvailable());
            dto.setPrice(product.getPrice());
            dto.setTaxAppliedPrice(product.getTaxAppliedPrice());
            dto.setStock(product.getStock());
            if(product.getOrderItemList() != null) {
                dto.setOrderItems(orderItemDto.orderItemListToDto(product.getOrderItemList()));
            }
            productDtoList.add(dto);
        }
        return productDtoList;
    }
}
