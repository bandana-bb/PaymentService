package dev.bandana.paymentservices.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkRequestDto {
    public long orderId;
}
