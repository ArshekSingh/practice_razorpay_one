package com.example.practice_razorpay_one.service;

import com.example.practice_razorpay_one.entity.RazorpayTransfer;
import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.razorpay.RazorpayException;

import java.util.List;

public interface CollectionService {

    List<PaymentDetails> fetchTransfer() throws RazorpayException;
    List<PaymentDetails> saveTransfer(List<RazorpayTransfer> transferlist) throws RazorpayException;
}
