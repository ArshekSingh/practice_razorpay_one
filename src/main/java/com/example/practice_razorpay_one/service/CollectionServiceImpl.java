package com.example.practice_razorpay_one.service;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayTransfer;
import com.example.practice_razorpay_one.mapper.RazorpayTransferMapper;
import com.example.practice_razorpay_one.repository.PaymentRepo;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private RazorpayTransferMapper razorpayTransferMapper;

    @Autowired
    private PaymentRepo paymentRepo;

    public List<PaymentDetails> fetchTransfer() throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", 100);
        List<Payment> transfers = razorpay.payments.fetchAll(jsonObject);
        List<RazorpayTransfer> transfer = razorpayTransferMapper.mapTransfers(transfers);
        System.out.println(transfer);
        List<PaymentDetails> paymentDetails = saveTransfer(transfer);
        return paymentDetails;

    }

    public List<PaymentDetails> saveTransfer(List<RazorpayTransfer> transferlist) throws RazorpayException {
        List<PaymentDetails> paymentDetails = new ArrayList<>();
        for (RazorpayTransfer transfer : transferlist) {
            PaymentDetails transferPayment = new PaymentDetails();
            transferPayment.setId(transfer.getId());
            transferPayment.setEntity(transfer.getEntity());
            transferPayment.setStatus(transfer.getStatus());
            transferPayment.setAmount(transfer.getAmount());
            transferPayment.setCurrency(transfer.getCurrency());
            transferPayment.setCreatedAt(transfer.getCreatedAt());
            transferPayment.setSettlement_status(transfer.getSettlement_status());
            paymentDetails.add(transferPayment);
        }
        paymentRepo.saveAll(paymentDetails);
        return paymentDetails;
    }

}
