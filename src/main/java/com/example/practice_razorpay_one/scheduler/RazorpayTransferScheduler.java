package com.example.practice_razorpay_one.scheduler;


import com.example.practice_razorpay_one.service.FetchPaymentService;
import com.example.practice_razorpay_one.service.RazorpayPaymentTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RazorpayTransferScheduler {

//    @Autowired
//    private FetchPaymentService collectionService;

        @Autowired
        private RazorpayPaymentTransfer razorpayPaymentTransfer;
    @Scheduled(fixedRate = 10000)
    public void fetchTransfer(){
       // collectionService.fetchPayment();
        razorpayPaymentTransfer.fetchTransfer();
    }
}
