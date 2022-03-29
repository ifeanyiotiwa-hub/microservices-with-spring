package org.betpawa.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.betpawa.loans.model.Customer;
import org.betpawa.loans.model.Loans;
import org.betpawa.loans.model.Properties;
import org.betpawa.loans.repository.LoansRepository;
import org.betpawa.loans.services.LoansServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoansController {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LoansController.class);
    private final LoansRepository loansRepository;

    private final LoansServiceConfig loansServiceConfig;

    @Autowired
    public LoansController(LoansRepository loansRepository, LoansServiceConfig loansServiceConfig) {
        this.loansRepository = loansRepository;
        this.loansServiceConfig = loansServiceConfig;
    }


    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestHeader("betPawa-correlation-id") String correlationId,  @RequestBody Customer customer) {
        System.out.println("Invoking Loans microservices");
        LOGGER.info("getLoanDetails() method started");
        LOGGER.info("getLoanDetails() method Ended");
        return loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());
    }

    @GetMapping("/loans/properties")
    public ResponseEntity<Properties> getLoansDetails() throws JsonProcessingException {
//        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties.LoansBuilder()
                                              .msg(loansServiceConfig.getMsg())
                .buildVersion(loansServiceConfig.getBuildVersion())
                .mailDetails(loansServiceConfig.getMailDetails())
                .activeBranches(loansServiceConfig.getActiveBranches())
                .build();

        return ResponseEntity.ok(properties);
    }
}
