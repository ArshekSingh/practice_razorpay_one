package com.example.practice_razorpay_one.mapper;


import com.example.practice_razorpay_one.entity.RazorpayTransfer;
import com.razorpay.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RazorpayTransferMapper {

    public List<RazorpayTransfer> mapTransfers(List<Payment> payments) {

        List<RazorpayTransfer> razorpayTransfers = new ArrayList<>();


        payments.forEach(payment -> {
            RazorpayTransfer razorpayTransfer = new RazorpayTransfer();
            if (!payment.toJson().isNull("id")) razorpayTransfer.setId(payment.get("id"));
            if (!payment.toJson().isNull("entity")) razorpayTransfer.setEntity(payment.get("entity"));
            if (!payment.toJson().isNull("amount")) razorpayTransfer.setAmount(payment.get("amount"));
            if (!payment.toJson().isNull("currency")) razorpayTransfer.setCurrency(payment.get("currency"));
            if (!payment.toJson().isNull("status")) razorpayTransfer.setStatus(payment.get("status"));
            if (!payment.toJson().isNull("order_id")) razorpayTransfer.setOrderId(payment.get("order_id"));
            if (!payment.toJson().isNull("method")) razorpayTransfer.setMethod(payment.get("method"));
            if (!payment.toJson().isNull("description")) razorpayTransfer.setDescription(payment.get("description"));
            if (!payment.toJson().isNull("amount_reversed"))
                razorpayTransfer.setAmountReversed(payment.get("amount_reversed"));
            if (!payment.toJson().isNull("captured")) razorpayTransfer.setCaptured(payment.get("captured"));
            if (!payment.toJson().isNull("bank")) razorpayTransfer.setBank(payment.get("bank"));
            if (!payment.toJson().isNull("email")) razorpayTransfer.setEmail(payment.get("email"));
            if (!payment.toJson().isNull("contact")) razorpayTransfer.setContact(payment.get("contact"));
            if (!payment.toJson().isNull("fee")) razorpayTransfer.setFee(payment.get("fee"));
            if (!payment.toJson().isNull("tax")) razorpayTransfer.setTax(payment.get("tax"));
            if (!payment.toJson().isNull("created_at")) razorpayTransfer.setCreatedAt(payment.get("created_at"));
            if (!payment.toJson().isNull("settlement_status"))
                razorpayTransfer.setSettlement_status(payment.get("settlement_status"));
            if (!payment.toJson().isNull("year")) razorpayTransfer.setSettlement_status(payment.get("year"));
            if (!payment.toJson().isNull("month")) razorpayTransfer.setSettlement_status(payment.get("month"));
            if (!payment.toJson().isNull("day")) razorpayTransfer.setSettlement_status(payment.get("day"));
            razorpayTransfers.add(razorpayTransfer);
        });
        return razorpayTransfers;

    }

}
