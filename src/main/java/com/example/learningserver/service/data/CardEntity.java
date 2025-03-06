package com.example.learningserver.service.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARD")
@Data
public class CardEntity {
    @Id
    @Column(name = "PAN")
    private String pan;
    @Column(name = "CIF")
    private String cif;
    @Column(name = "PAYAPPNO")
    private String paymentApplicationNumber;
    @Column(name = "PAYAPPTYP")
    private PaymentApplicationType PaymentApplicationType;
}
