package org.betpawa.cards.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.betpawa.cards.models.Cards;
import org.betpawa.cards.models.Customer;
import org.betpawa.cards.models.Properties;
import org.betpawa.cards.repository.CardsRepository;
import org.betpawa.cards.services.CardsServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CardsController.class);
    private final CardsRepository cardsRepository;
    private final CardsServiceConfig cardsServiceConfig;

    @Autowired
    public CardsController(CardsRepository cardsRepository, CardsServiceConfig cardsServiceConfig) {
        this.cardsRepository = cardsRepository;
        this.cardsServiceConfig = cardsServiceConfig;
    }


    @PostMapping("/myCards")
    public List<Cards> getMCardDetails(@RequestBody Customer customer) {
        LOGGER.info("getMCardDetails() method Started.");
        LOGGER.info("getMCardDetails() method Ended.");
        return cardsRepository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/cards/properties")
    public ResponseEntity<Properties> getCardProperties() throws JsonProcessingException {
//        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Properties properties = new Properties.CardsBuilder().msg(cardsServiceConfig.getMsg())
                .buildVersion(cardsServiceConfig.getBuildVersion())
                .mailDetails(cardsServiceConfig.getMailDetails())
                .activeBranches(cardsServiceConfig.getActiveBranches())
                .build();

        return ResponseEntity.ok(properties);

    }
}
