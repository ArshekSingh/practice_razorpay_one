package com.example.practice_razorpay_one.service;


import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.example.practice_razorpay_one.mapper.RazorpayPaymentMapper;
import com.example.practice_razorpay_one.response.Response;
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
    private RazorpayPaymentMapper razorpayTransferMapper;

    @Autowired
    private SavePaymentService savePaymentService;

    //Dependency Injection through constructor---alternative option which is not used in this code.
    public FetchPaymentServiceImpl(SavePaymentService savePaymentService) {
        this.savePaymentService = savePaymentService;
    }

    public List<PaymentDetails> fetchPayment() {
        List<RazorpayPayment> transferList = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("count", 100);
            List<Payment> transfers = razorpay.payments.fetchAll(jsonObject);
            transferList = razorpayTransferMapper.mapPayments(transfers);
            System.out.println(transferList);
            for (RazorpayPayment transfer : transferList) {
                Response<PaymentDetails> paymentDetailsResponse = savePaymentService.savePayment(transfer);
                //If the request is successful
                if (paymentDetailsResponse.getCode() == HttpStatus.OK.value()) {
                    log.info("Payment is fetched");

                } else {
                    log.error("Error in fetching payment");//log why the save failed
                }
            }
        } catch (RazorpayException razorpayException) {
            log.error("error in razorpay fetch payments api paymentId {}");
            razorpayException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("exception while fetching payments", exception);
        }
        return null;
    }

}
