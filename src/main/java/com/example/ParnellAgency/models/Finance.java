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

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private int case_cost;
    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;
    private String recipient_account;
    @Enumerated(EnumType.STRING)
    private PaymentStatus payment_status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "investigation_id")
    private Investigation investigation;


    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

}
