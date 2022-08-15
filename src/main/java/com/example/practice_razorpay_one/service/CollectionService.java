package com.example.practice_razorpay_one.service;

import com.example.practice_razorpay_one.entity.CollectionDetail;
import com.example.practice_razorpay_one.entity.LoanDetail;
import com.example.practice_razorpay_one.entity.TransactionDetail;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CollectionService {
    //CollectionDetail saveCollection(LoanDetail loanDetail, Integer collectionSequence, TransactionDetail transaction, BigDecimal amountToBeCollected);
    Optional<List<CollectionDetail>> findByTransferId();
}
