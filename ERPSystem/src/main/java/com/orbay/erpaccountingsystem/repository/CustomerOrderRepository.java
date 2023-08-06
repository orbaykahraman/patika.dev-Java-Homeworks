package com.orbay.erpaccountingsystem.repository;

import com.orbay.erpaccountingsystem.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {

}
