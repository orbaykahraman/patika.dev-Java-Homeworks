package com.orbay.erpaccountingsystem.repository;

import com.orbay.erpaccountingsystem.model.Bill;
import com.orbay.erpaccountingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
