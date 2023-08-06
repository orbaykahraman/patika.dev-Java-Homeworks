package com.orbay.erpaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.orbay.erpaccountingsystem.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {


    private String name;

    @OneToOne(mappedBy = "customer")
    private CustomerOrder customerOrder;

    @OneToMany(mappedBy = "customer")
    private List<Bill> billList;

}
