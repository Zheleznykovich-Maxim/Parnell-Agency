package com.example.OrderService.models;

import com.example.OrderService.models.enums.StatusType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "investigation")
public class Investigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String specification;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "ID_client")
    private Client client;

    @OneToOne(mappedBy = "investigation", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Finance finance;

}

