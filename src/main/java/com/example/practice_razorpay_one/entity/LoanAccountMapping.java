package com.example.practice_razorpay_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "loan_account_mapping")
public class LoanAccountMapping {
    @Id
    @Column(name = "loan_account_map_id")
    private Integer loanAccountMapId;

    @Column(name = "loan_id")
    private Integer loanId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "status")
    private String status;

    @Column(name = "info1")
    private String info1;

    @Column(name = "info2")
    private String info2;

    @Column(name = "salt")
    private String salt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
}
