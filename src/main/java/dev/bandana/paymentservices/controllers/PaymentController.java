package dev.bandana.paymentservices.controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.bandana.paymentservices.dto.GeneratePaymentLinkRequestDto;
import dev.bandana.paymentservices.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    PaymentService paymentService;
    public PaymentController(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto getPaymentLinkRequestDto) throws RazorpayException, StripeException {
             //return payment link

        return paymentService.generatePaymentLink(getPaymentLinkRequestDto.orderId);
        
    }


    @PostMapping("/webhook")//PaymentGateway will call this api on change of payment status
    public void handleWebHook(@RequestBody Object object){
        //here is where you decide what you want to do
        //you can go to razorpay dashboard and set these webhooks
    }
}
