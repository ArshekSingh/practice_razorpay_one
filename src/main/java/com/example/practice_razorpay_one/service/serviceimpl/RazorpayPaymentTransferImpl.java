package com.example.practice_razorpay_one.service.serviceimpl;

import com.example.practice_razorpay_one.entity.PaymentDetails;
import com.example.practice_razorpay_one.entity.RazorpayTransfer;
import com.example.practice_razorpay_one.mapper.RazorpayTransferMapper;
import com.example.practice_razorpay_one.service.RazorpayPaymentTransfer;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RazorpayPaymentTransferImpl implements RazorpayPaymentTransfer {


    @Autowired
    private RazorpayTransferMapper razorpayTransferMapper;

    @Override
    public List<PaymentDetails> fetchTransfer() {
        List<RazorpayTransfer> transferList = null;
        try{

            RazorpayClient razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("count", 100);  //trf_K37FE9OVYj8tz6
            List<Transfer> transfers = razorpay.transfers.fetchAll(jsonObject);
            transferList = razorpayTransferMapper.mapTransfer(transfers);
            System.out.println(transferList);


        }
        catch (RazorpayException e) {
            log.error("error in razorpay fetch transfer api paymentId {}");
            e.printStackTrace();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            log.error("exception while fetching transfers", exception);

        }
        return null;
    }

    @Override
    public RazorpayTransfer fetchTransferById() {


        RazorpayTransfer razorpayTransfer = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");
            String transferId = "trf_K37FE9OVYj8tz6";
            Transfer transfer = razorpay.transfers.fetch(transferId);
            razorpayTransfer = razorpayTransferMapper.mapTransfer(transfer);
            System.out.println(razorpayTransfer);
        } catch (RazorpayException e) {
            log.error("error in razorpay fetch transfer api paymentId {}");
            throw new RuntimeException(e);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("exception while fetching transfers", exception);
        }


        return razorpayTransfer;

    }
}
