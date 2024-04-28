package com.example.ParnellAgency.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_client")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    private String roles;
}
