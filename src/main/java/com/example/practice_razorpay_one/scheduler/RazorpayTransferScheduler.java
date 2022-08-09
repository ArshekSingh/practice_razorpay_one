package com.example.practice_razorpay_one.scheduler;


import com.example.practice_razorpay_one.service.CollectionService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RazorpayTransferScheduler {

    @Autowired
    private CollectionService collectionService;
    @Scheduled(fixedRate = 10000)
    public void fetchTransfer() throws RazorpayException{

        collectionService.fetchTransfer();
    }
}
