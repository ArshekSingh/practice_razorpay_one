package com.example.practice_razorpay_one.service;

import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.example.practice_razorpay_one.response.Response;

public interface SavePaymentService {

    Response<PaymentDetails> savePayment(RazorpayPayment transferlist);}
