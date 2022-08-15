package com.example.practice_razorpay_one.service.serviceimpl;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.example.practice_razorpay_one.mapper.RazorpayPaymentMapper;
import com.example.practice_razorpay_one.response.Response;
import com.example.practice_razorpay_one.service.FetchPaymentService;
import com.example.practice_razorpay_one.service.SavePaymentService;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FetchPaymentServiceImpl implements FetchPaymentService {

    @Autowired
    private RazorpayPaymentMapper razorpayPaymentMapper;

    @Autowired
    private SavePaymentService savePaymentService;

    //Dependency Injection through constructor---alternative option which is not used in this code.
    public FetchPaymentServiceImpl(SavePaymentService savePaymentService) {
        this.savePaymentService = savePaymentService;
    }

    public List<RazorpayPayment> fetchPayment() {
        List<RazorpayPayment> paymentList = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("count", 100);
            List<Payment> payments = razorpay.payments.fetchAll(jsonObject);
            paymentList = razorpayPaymentMapper.mapPayments(payments);
            System.out.println(paymentList);
            for (RazorpayPayment payment : paymentList) {
                Response<PaymentDetails> paymentDetailsResponse = savePaymentService.savePayment(payment);
                //If the request is successful
                if (paymentDetailsResponse.getCode() == HttpStatus.OK.value()) {
                    log.info("Payment is payment is stored in DB.");

                } else {
                    log.error("Error in storing payment in DB");//log why the save failed
                }
            }
        } catch (RazorpayException razorpayException) {
            log.error("error in razorpay fetch payments api paymentId {}");
            razorpayException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("exception while fetching payments", exception);
        }
        return paymentList;
    }

}
