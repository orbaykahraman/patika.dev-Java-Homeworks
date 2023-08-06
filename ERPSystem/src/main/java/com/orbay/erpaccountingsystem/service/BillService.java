package com.orbay.erpaccountingsystem.service;

import com.orbay.erpaccountingsystem.config.TaxRateConfig;
import com.orbay.erpaccountingsystem.dto.BillDto;
import com.orbay.erpaccountingsystem.model.Bill;
import com.orbay.erpaccountingsystem.model.Customer;
import com.orbay.erpaccountingsystem.model.CustomerOrder;
import com.orbay.erpaccountingsystem.repository.BillRepository;
import com.orbay.erpaccountingsystem.repository.CustomerOrderRepository;
import com.orbay.erpaccountingsystem.repository.CustomerRepository;
import com.orbay.erpaccountingsystem.util.OrderStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    TaxRateConfig taxRateConfig;

    BillDto billDto = new BillDto();
    public List<BillDto> findAllBillsForCustomer(Long customerId) {
        return billDto.billListToDtoList(billRepository.getBillsByCustomerId(customerId));
    }

    public BillDto findBillById(Long billId) {
        if(billRepository.findById(billId).isPresent()) {
            return billDto.billToDto(billRepository.findById(billId).orElseThrow());
        }
        return null;
    }

    @Transactional
    public BillDto createBillForCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        if(!customer.getCustomerOrder().getOrderStatus().equalsIgnoreCase(OrderStatus.DEFAULT.getOrderValue()) ){
            return null;
        }
        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setCreationDate(new Date());
        bill.setTotalPrice(taxRateConfig.calculatePriceWithTaxRate(customer.getCustomerOrder().getTotalAmount()));
        customer.getCustomerOrder().setOrderStatus(OrderStatus.APPROVED.getOrderValue());
        CustomerOrder customerOrder = customer.getCustomerOrder();
        customerRepository.save(customer);
        customerOrderRepository.save(customerOrder);
        billRepository.save(bill);
        return billDto.billToDto(bill);
    }

}
