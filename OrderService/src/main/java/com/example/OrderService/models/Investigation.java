package com.example.OrderService.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "investigation")
public class Investigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String specification;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "ID_client")
    private Client client;
}

