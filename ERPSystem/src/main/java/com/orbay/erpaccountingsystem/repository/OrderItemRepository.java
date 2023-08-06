package com.orbay.erpaccountingsystem.repository;

import com.orbay.erpaccountingsystem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    List<OrderItem> findAllByCustomerOrderName(String name);
}
