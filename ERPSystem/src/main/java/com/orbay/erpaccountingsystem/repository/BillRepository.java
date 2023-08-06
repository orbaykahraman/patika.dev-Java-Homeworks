package com.orbay.erpaccountingsystem.repository;

import com.orbay.erpaccountingsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

    List<Bill> getBillsByCustomerId(Long customerId);
}
