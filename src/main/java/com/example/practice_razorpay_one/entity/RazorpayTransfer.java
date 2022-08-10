package com.example.practice_razorpay_one.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RazorpayTransfer {

    private String id;
    private String entity;
    private String status;
    private String transfer_status;
    private String settlement_status;
    private String source;
    private String recipient;
    private Integer amount;
    private String currency;
    private String method;
    private String bank;
    private String email;
    private String contact;
    private Integer fee;
    private Integer tax;
    private Boolean captured;
    private String orderId;
    private Integer amountReversed;
    private String description;

    //private Notes notes;
    private List<String> linkedAccountNotes = new ArrayList<>();
    private Boolean onHold;
    private Object onHoldUntil;
    private Object recipientSettlementId;
    private Date createdAt;
    private Object processedAt;
    private Error error;

}
