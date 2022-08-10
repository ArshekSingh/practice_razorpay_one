package com.example.practice_razorpay_one.service;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.example.practice_razorpay_one.repository.PaymentRepo;
import com.example.practice_razorpay_one.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class SavePaymentServiceImpl implements SavePaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Transactional
    public Response<PaymentDetails> savePayment(RazorpayPayment transfer) {
        Response<PaymentDetails> response = new Response();
        try {
            PaymentDetails transferPayment = new PaymentDetails();
            transferPayment.setId(transfer.getId());
            transferPayment.setEntity(transfer.getEntity());
            transferPayment.setStatus(transfer.getStatus());
            transferPayment.setAmount(transfer.getAmount());
            transferPayment.setCurrency(transfer.getCurrency());
            transferPayment.setCreatedAt(transfer.getCreatedAt());
            transferPayment.setSettlement_status(transfer.getSettlement_status());
            transferPayment = paymentRepo.save(transferPayment);

            //add logs
            response.setCode(HttpStatus.OK.value());
            response.setData(transferPayment);
            response.setMessage("Success");
            return response;

        } catch (Exception exception) {
            response.setCode(HttpStatus.BAD_REQUEST.value());
            response.setData(null);
            response.setMessage(HttpStatus.BAD_REQUEST.toString());
            return response;
        }
    }

}
