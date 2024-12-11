package dev.bandana.paymentservices.services;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public String generatePaymentLink(long orderId) throws RazorpayException, StripeException;
}
