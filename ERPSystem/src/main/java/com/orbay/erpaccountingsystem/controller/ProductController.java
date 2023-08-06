package com.orbay.erpaccountingsystem.controller;

import com.orbay.erpaccountingsystem.dto.ProductDto;
import com.orbay.erpaccountingsystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orbay.erpaccountingsystem.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createNewProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createNewProduct(product),HttpStatus.CREATED);
    }
    @PutMapping("/setAvailability/{productId}")
    public ResponseEntity<ProductDto> setProductAvailability(@PathVariable(name = "productId") Long productId) {

        ProductDto dto = productService.setProductAvailability(productId);
        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProductDto> findProductById(@PathVariable(name = "id") Long productId) {
        ProductDto dto = productService.findProductDtoById(productId);
        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "id") Long productId) {
        if(productService.deleteProductById(productId)) {
            return new ResponseEntity<>("Product with id " + productId + " is deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable(name = "id") Long productId,@RequestBody Product newProduct) {
        ProductDto dto = productService.updateProductById(productId,newProduct);
        if(dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

}
