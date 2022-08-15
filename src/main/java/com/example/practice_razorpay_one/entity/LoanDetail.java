package com.example.practice_razorpay_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "loan_detail")
public class LoanDetail {
    @Id
    @Column(name = "loan_id")
    private Integer loanId;

    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    //("A", "I", "C")
    @Column(name = "status")
    private String loanStatus;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "closure_date")
    private LocalDateTime closureDate;

    @Column(name = "disbursement_date")
    private LocalDateTime disbursementDate;

    @Column(name = "cap_percentage")
    private Integer capPercentage;

    @Column(name = "month_strt_date")
    private LocalDateTime monthStartDate;

    @Column(name = "yearly_strt_date")
    private LocalDateTime yearlyStartDate;

    @Column(name = "week_strt_date")
    private LocalDateTime weekStartDate;

    @Column(name = "daily_limit_amt")
    private BigDecimal dailyLimitAmount;

    @Column(name = "weekly_limit_amt")
    private BigDecimal weeklyLimitAmount;

    @Column(name = "monthly_limit_amt")
    private BigDecimal monthlyLimitAmount;

    @Column(name = "yearly_limit_amt")
    private BigDecimal yearlyLimitAmount;

    @Column(name = "funder_account_id")
    private String funderAccountId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

}
