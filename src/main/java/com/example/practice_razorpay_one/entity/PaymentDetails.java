package com.example.practice_razorpay_one.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "payment_detail")
public class PaymentDetails {

    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
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
