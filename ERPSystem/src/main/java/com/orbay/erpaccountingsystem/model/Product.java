package com.orbay.erpaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.orbay.erpaccountingsystem.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private String info;
    private double price;
    private int stock;
    private boolean isProductAvailable;
    private double taxAppliedPrice;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItemList;
}
