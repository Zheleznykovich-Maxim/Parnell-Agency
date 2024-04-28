package com.example.ParnellAgency.models;

import com.example.ParnellAgency.models.enums.PaymentMethod;
import com.example.ParnellAgency.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Finance {

    @Id
    @Column(name = "ID_investigation")
    private int id;
    @Column(nullable=false)
    private int case_cost;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PaymentMethod payment_method;
    @Column(nullable=false)
    private String recipient_account;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PaymentStatus payment_status;
    @OneToOne
    @MapsId
    @JoinColumn(name = "investigation_id", nullable = false)
    private Investigation investigation;


}
