package com.example.practice_razorpay_one.scheduler;


import com.example.practice_razorpay_one.entity.CollectionDetail;
import com.example.practice_razorpay_one.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RazorpayTransferScheduler {

    @Autowired
    private CollectionService service;

    @Scheduled(fixedRate = 50000)
    public void fetchTransfer() {

        //collectionService.fetchPayment();
        //razorpayPaymentTransfer.fetchTransfer();
        // razorpayPaymentTransfer.fetchTransferById();
        Optional<List<CollectionDetail>> collectionDetails = service.findByTransferId();
//        if(collectionDetails.isEmpty()){
//
//        } else {
//            for(CollectionDetail collectionDetail: collectionDetails.get()){
//                razorpay
//            }
//        }
//        System.out.println(collectionDetails.toString());

    }
}
