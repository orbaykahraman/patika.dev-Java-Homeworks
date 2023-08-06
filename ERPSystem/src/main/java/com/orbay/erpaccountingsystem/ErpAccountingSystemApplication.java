package com.orbay.erpaccountingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ErpAccountingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpAccountingSystemApplication.class, args);
    }

}
