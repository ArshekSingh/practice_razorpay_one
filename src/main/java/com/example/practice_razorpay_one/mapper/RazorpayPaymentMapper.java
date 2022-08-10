package com.example.practice_razorpay_one.mapper;


import com.example.practice_razorpay_one.entity.RazorpayPayment;
import com.razorpay.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RazorpayPaymentMapper {

    public List<RazorpayPayment> mapPayments(List<Payment> payments) {

        List<RazorpayPayment> razorpayPayments = new ArrayList<>();


        payments.forEach(payment -> {
            RazorpayPayment razorpayPayment = new RazorpayPayment();
            if (!payment.toJson().isNull("id")) razorpayPayment.setId(payment.get("id"));
            if (!payment.toJson().isNull("entity")) razorpayPayment.setEntity(payment.get("entity"));
            if (!payment.toJson().isNull("amount")) razorpayPayment.setAmount(payment.get("amount"));
            if (!payment.toJson().isNull("currency")) razorpayPayment.setCurrency(payment.get("currency"));
            if (!payment.toJson().isNull("status")) razorpayPayment.setStatus(payment.get("status"));
            if (!payment.toJson().isNull("order_id")) razorpayPayment.setOrderId(payment.get("order_id"));
            if (!payment.toJson().isNull("method")) razorpayPayment.setMethod(payment.get("method"));
            if (!payment.toJson().isNull("description")) razorpayPayment.setDescription(payment.get("description"));
            if (!payment.toJson().isNull("amount_reversed"))
                razorpayPayment.setAmountReversed(payment.get("amount_reversed"));
            if (!payment.toJson().isNull("captured")) razorpayPayment.setCaptured(payment.get("captured"));
            if (!payment.toJson().isNull("bank")) razorpayPayment.setBank(payment.get("bank"));
            if (!payment.toJson().isNull("email")) razorpayPayment.setEmail(payment.get("email"));
            if (!payment.toJson().isNull("contact")) razorpayPayment.setContact(payment.get("contact"));
            if (!payment.toJson().isNull("fee")) razorpayPayment.setFee(payment.get("fee"));
            if (!payment.toJson().isNull("tax")) razorpayPayment.setTax(payment.get("tax"));
            if (!payment.toJson().isNull("created_at")) razorpayPayment.setCreatedAt(payment.get("created_at"));
            if (!payment.toJson().isNull("settlement_status"))
                razorpayPayment.setSettlement_status(payment.get("settlement_status"));
            if (!payment.toJson().isNull("year")) razorpayPayment.setSettlement_status(payment.get("year"));
            if (!payment.toJson().isNull("month")) razorpayPayment.setSettlement_status(payment.get("month"));
            if (!payment.toJson().isNull("day")) razorpayPayment.setSettlement_status(payment.get("day"));
            razorpayPayments.add(razorpayPayment);
        });
        return razorpayPayments;

    }

}
