package com.example.practice_razorpay_one.service;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayTransfer;

import java.util.List;

public interface RazorpayPaymentTransfer {

    List<PaymentDetails> fetchTransfer();

    RazorpayTransfer fetchTransferById();

}
