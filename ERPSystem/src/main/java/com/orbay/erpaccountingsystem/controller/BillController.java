package com.orbay.erpaccountingsystem.controller;

import com.orbay.erpaccountingsystem.dto.BillDto;
import com.orbay.erpaccountingsystem.model.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orbay.erpaccountingsystem.service.BillService;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/allbills/{customerId}")
    public ResponseEntity<List<BillDto>> findAllBillsForCustomer(@PathVariable(name = "customerId") Long customerId) {
        return new ResponseEntity<>(billService.findAllBillsForCustomer(customerId), HttpStatus.FOUND);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<BillDto> findBillById(@PathVariable(name = "billId") Long billId) {
        BillDto BillDto = billService.findBillById(billId);
        if(BillDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(BillDto,HttpStatus.FOUND);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<BillDto> createBillForCustomer(@PathVariable(name = "customerId") Long customerId) {
        BillDto billDto = billService.createBillForCustomer(customerId);
        if(billDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billDto, HttpStatus.CREATED);
    }

}
