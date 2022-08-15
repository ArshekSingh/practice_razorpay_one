package com.example.practice_razorpay_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "transaction_detail")
public class TransactionDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loan_account_map_id")
    private Integer loanAccountMapId;

    @Column(name = "acc_id")
    private String accountId;

    @Column(name = "loan_id")
    private Integer loanId;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_txn_id")
    private String bankTransactionId;

    @Column(name = "contact_no")
    private String contactNumber;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description")
    private String description;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "refund_id")
    private String refundId;

    @Column(name = "response", columnDefinition = "text")
    private String response;

    @Column(name = "txn_amount")
    private BigDecimal transactionAmount;

    @Column(name = "txn_date")
    private LocalDateTime transactionDate;

    @Column(name = "txn_fee")
    private Integer transactionFee;

    @Column(name = "txn_id")
    private String transactionId;

    @Column(name = "txn_mode")
    private String transactionMode;

    /**
     * STATUS = {"C: CAPTURED", "P: PROCESSED", "S: SETTLED"}
     **/
    @Column(name = "status")
    private String transactionStatus;

    @Column(name = "txn_tax")
    private Integer transactionTax;
}
