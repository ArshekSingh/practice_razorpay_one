package com.example.practice_razorpay_one.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CollectionDetailPK implements Serializable {

    private static final long serialVersionUID = -3364513487072037091L;
    @Column(name = "coll_seq")
    private Integer collectionSequence;

    @Column(name = "loan_id")
    private Integer loanId;

}
