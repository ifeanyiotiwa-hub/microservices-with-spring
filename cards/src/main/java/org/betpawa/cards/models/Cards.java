package org.betpawa.cards.models;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private long cardId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
