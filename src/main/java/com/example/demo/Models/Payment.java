package com.example.demo.Models;

import ch.qos.logback.core.model.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String thirdPartyReferenceID;

}
