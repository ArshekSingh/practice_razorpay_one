package com.example.practice_razorpay_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "COLLECTION_DETAIL")
public class CollectionDetail {
    @EmbeddedId
    private CollectionDetailPK collectionDetailPK;

    @Column(name = "collection_amt")
    private BigDecimal collectionAmount;

    @Column(name = "collection_date")
    private LocalDateTime collectionDate;

    /**
     * Status: "P" : Pending, "C": Collected, "F": Failed
     **/
    @Column(name = "status")
    private String status;

    @Column(name = "transfer_id")
    private String transferId;

    @Column(name = "coll_type")
    private String collectionType;

    @Column(name = "refund_txn_id")
    private String refundTransactionId;

    @Column(name = "txn_id")
    private String transactionId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

}

