package com.example.learningserver.api.dto;

import lombok.Data;

@Data
public class CardEntityDto {
    private String pan;
    private String cif;
    private String paymentApplicationNumber;
    private PaymentApplicationTypeDto PaymentApplicationType;
}
