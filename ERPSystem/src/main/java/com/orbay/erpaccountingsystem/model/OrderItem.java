package com.orbay.erpaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import com.orbay.erpaccountingsystem.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem extends BaseEntity {

    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_order_id",referencedColumnName = "id")
    private CustomerOrder customerOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id",referencedColumnName = "id")
    private Bill bill;

    private int quantity;
}
