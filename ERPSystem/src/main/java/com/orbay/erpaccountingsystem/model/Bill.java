package com.orbay.erpaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.orbay.erpaccountingsystem.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Bill extends BaseEntity {


    private double totalPrice;

    @OneToMany(mappedBy = "bill")
    private List<OrderItem> orderItemList;

    @ManyToOne
    private Customer customer;

}
