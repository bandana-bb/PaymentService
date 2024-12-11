package dev.bandana.paymentservices.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayPaymentGateway implements PaymentService{

    private final RazorpayClient razorpayClient;


    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public String generatePaymentLink(long orderId) throws RazorpayException{
        //will i need to make a call to order details
        //we will learn this in authentication module after machine coding
        //thorugh rest api call we can make a call


        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000); //Rs 10.00
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",+ System.currentTimeMillis() + 10*60*1000);
        paymentLinkRequest.put("reference_id",
                orderId);
        paymentLinkRequest.put("description","Payment for excited batch");
        JSONObject customer = new JSONObject();
        customer.put("name","+bandana ");
        customer.put("contact","872428292");
        customer.put("email","bandanabharti444@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://google.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }


}
