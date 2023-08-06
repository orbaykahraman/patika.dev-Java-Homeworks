package com.orbay.erpaccountingsystem.model;

import com.orbay.erpaccountingsystem.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder extends BaseEntity {

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<OrderItem> orderItemList;

    private double totalAmount;

    private String orderStatus;

}
