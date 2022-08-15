package com.example.practice_razorpay_one.mapper;

import com.example.practice_razorpay_one.entity.RazorpayTransfer;
import com.razorpay.Transfer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RazorpayTransferMapper {

    public RazorpayTransfer mapTransfer(Transfer transfer){


        RazorpayTransfer razorpayTransfer = new RazorpayTransfer();

        if (!transfer.toJson().isNull("id")) razorpayTransfer.setId(transfer.get("id"));
        if (!transfer.toJson().isNull("entity")) razorpayTransfer.setEntity(transfer.get("entity"));
        if (!transfer.toJson().isNull("amount")) razorpayTransfer.setAmount(transfer.get("amount"));
        if (!transfer.toJson().isNull("currency")) razorpayTransfer.setCurrency(transfer.get("currency"));
        if (!transfer.toJson().isNull("status")) razorpayTransfer.setStatus(transfer.get("status"));
        if (!transfer.toJson().isNull("payment_id")) razorpayTransfer.setPayment_id(transfer.get("payment_id"));
        if (!transfer.toJson().isNull("order_id")) razorpayTransfer.setOrderId(transfer.get("order_id"));
        if (!transfer.toJson().isNull("method")) razorpayTransfer.setMethod(transfer.get("method"));
        if (!transfer.toJson().isNull("description")) razorpayTransfer.setDescription(transfer.get("description"));
        if (!transfer.toJson().isNull("amount_reversed"))
            razorpayTransfer.setAmountReversed(transfer.get("amount_reversed"));
        if (!transfer.toJson().isNull("captured")) razorpayTransfer.setCaptured(transfer.get("captured"));
        if (!transfer.toJson().isNull("bank")) razorpayTransfer.setBank(transfer.get("bank"));
        if (!transfer.toJson().isNull("email")) razorpayTransfer.setEmail(transfer.get("email"));
        if (!transfer.toJson().isNull("contact")) razorpayTransfer.setContact(transfer.get("contact"));
        if (!transfer.toJson().isNull("fee")) razorpayTransfer.setFee(transfer.get("fee"));
        if (!transfer.toJson().isNull("tax")) razorpayTransfer.setTax(transfer.get("tax"));
        if (!transfer.toJson().isNull("created_at")) razorpayTransfer.setCreatedAt(transfer.get("created_at"));
        if (!transfer.toJson().isNull("settlement_status"))
            razorpayTransfer.setSettlement_status(transfer.get("settlement_status"));
        if (!transfer.toJson().isNull("year")) razorpayTransfer.setSettlement_status(transfer.get("year"));
        if (!transfer.toJson().isNull("month")) razorpayTransfer.setSettlement_status(transfer.get("month"));
        if (!transfer.toJson().isNull("day")) razorpayTransfer.setSettlement_status(transfer.get("day"));

        return razorpayTransfer;


    }

    public List<RazorpayTransfer> mapTransfer(List<Transfer> transferList){

        List<RazorpayTransfer> razorpayTransfers = new ArrayList<>();

        transferList.forEach(transfer -> {
            RazorpayTransfer razorpayTransfer = new RazorpayTransfer();

            if (!transfer.toJson().isNull("id")) razorpayTransfer.setId(transfer.get("id"));
            if (!transfer.toJson().isNull("entity")) razorpayTransfer.setEntity(transfer.get("entity"));
            if (!transfer.toJson().isNull("amount")) razorpayTransfer.setAmount(transfer.get("amount"));
            if (!transfer.toJson().isNull("currency")) razorpayTransfer.setCurrency(transfer.get("currency"));
            if (!transfer.toJson().isNull("status")) razorpayTransfer.setStatus(transfer.get("status"));
            if (!transfer.toJson().isNull("order_id")) razorpayTransfer.setOrderId(transfer.get("order_id"));
            if (!transfer.toJson().isNull("method")) razorpayTransfer.setMethod(transfer.get("method"));
            if (!transfer.toJson().isNull("description")) razorpayTransfer.setDescription(transfer.get("description"));
            if (!transfer.toJson().isNull("amount_reversed"))
                razorpayTransfer.setAmountReversed(transfer.get("amount_reversed"));
            if (!transfer.toJson().isNull("captured")) razorpayTransfer.setCaptured(transfer.get("captured"));
            if (!transfer.toJson().isNull("bank")) razorpayTransfer.setBank(transfer.get("bank"));
            if (!transfer.toJson().isNull("email")) razorpayTransfer.setEmail(transfer.get("email"));
            if (!transfer.toJson().isNull("contact")) razorpayTransfer.setContact(transfer.get("contact"));
            if (!transfer.toJson().isNull("fee")) razorpayTransfer.setFee(transfer.get("fee"));
            if (!transfer.toJson().isNull("tax")) razorpayTransfer.setTax(transfer.get("tax"));
            if (!transfer.toJson().isNull("created_at")) razorpayTransfer.setCreatedAt(transfer.get("created_at"));
            if (!transfer.toJson().isNull("settlement_status"))
                razorpayTransfer.setSettlement_status(transfer.get("settlement_status"));
            if (!transfer.toJson().isNull("year")) razorpayTransfer.setSettlement_status(transfer.get("year"));
            if (!transfer.toJson().isNull("month")) razorpayTransfer.setSettlement_status(transfer.get("month"));
            if (!transfer.toJson().isNull("day")) razorpayTransfer.setSettlement_status(transfer.get("day"));
            razorpayTransfers.add(razorpayTransfer);


        });

            return razorpayTransfers;

    }
}
