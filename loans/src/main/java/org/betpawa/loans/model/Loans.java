package org.betpawa.loans.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
public class Loans {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number")
    private long loanNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
