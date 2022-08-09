package com.example.practice_razorpay_one.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Data
@Table(name = "payment_detail")
public class PaymentDetails {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    @Column
    private String id;
    @Column
    private String entity;
    @Column
    private String status;
    @Column
    private Integer amount;
    @Column
    private String currency;
    @Column
    private Date createdAt;
    @Column
    private String settlement_status;


}
