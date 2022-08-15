package com.example.practice_razorpay_one.service.serviceimpl;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.example.practice_razorpay_one.repository.PaymentRepo;
import com.example.practice_razorpay_one.response.Response;
import com.example.practice_razorpay_one.service.SavePaymentService;
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
    public Response<PaymentDetails> savePayment(RazorpayPayment payment) {
        Response<PaymentDetails> response = new Response();
        try {
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setId(payment.getId());
            paymentDetails.setEntity(payment.getEntity());
            paymentDetails.setStatus(payment.getStatus());
            paymentDetails.setAmount(payment.getAmount());
            paymentDetails.setCurrency(payment.getCurrency());
            paymentDetails.setCreatedAt(payment.getCreatedAt());
            paymentDetails.setSettlement_status(payment.getSettlement_status());
            paymentDetails = paymentRepo.save(paymentDetails);

            //add logs
            response.setCode(HttpStatus.OK.value());
            response.setData(paymentDetails);
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
