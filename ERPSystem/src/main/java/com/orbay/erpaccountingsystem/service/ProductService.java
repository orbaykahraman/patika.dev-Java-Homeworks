package com.orbay.erpaccountingsystem.service;

import com.orbay.erpaccountingsystem.dto.ProductDto;
import com.orbay.erpaccountingsystem.model.Product;
import com.orbay.erpaccountingsystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    ProductDto productDto = new ProductDto();
    public List<ProductDto> findAllProducts() {

       return productDto.productListToDtoList(productRepository.findAll());
    }

    public ProductDto createNewProduct(Product product) {
        product.setCreationDate(new Date());
        return productDto.productToDto(productRepository.save(product));
    }

    public ProductDto findProductDtoById(Long productId) {
        if(productRepository.findById(productId).isPresent()) {
            return productDto.productToDto(productRepository.findById(productId).get());
        }
        return null;
    }
    public Product findProductById(Long productId) {

        if(productRepository.findById(productId).isPresent()) {
            return productRepository.findById(productId).get();
        }
        return null;
    }

    public ProductDto updateProductById(Long productId, Product newProduct) {
        if(productRepository.findById(productId).isPresent()) {
            Product oldProduct = productRepository.findById(productId).orElseThrow();
            oldProduct.setProductAvailable(newProduct.isProductAvailable());
            oldProduct.setName(newProduct.getName());
            oldProduct.setInfo(newProduct.getInfo());
            oldProduct.setStock(newProduct.getStock());
            oldProduct.setPrice(newProduct.getPrice());
            oldProduct.setOrderItemList(newProduct.getOrderItemList());
            oldProduct.setTaxAppliedPrice(newProduct.getTaxAppliedPrice());
            oldProduct.setUpdatedDate(newProduct.getUpdatedDate());
            productRepository.save(oldProduct);
            return productDto.productToDto(oldProduct);
        }
        else {
            return null;
        }
    }

    public boolean deleteProductById(Long productId) {
        if(productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        else {
            return false;
        }
    }

    public void updateStockAfterOrderItem(int quantity, Product product) {
        product.setStock(product.getStock() - quantity);
        product.setUpdatedDate(new Date());
        productRepository.save(product);
//        productRepository.updateStock(product.getStock()-quantity,product.getId());
    }

    public ProductDto setProductAvailability(Long productId) {
        if(productRepository.findById(productId).isPresent()) {
            Product product = productRepository.findById(productId).orElseThrow();
            product.setProductAvailable(!product.isProductAvailable());
            product.setUpdatedDate(new Date());
            productRepository.save(product);
        }
        return null;
    }
}
