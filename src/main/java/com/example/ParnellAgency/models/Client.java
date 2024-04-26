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
    private int id;
    private String name;
    private String case_description;
    private String phone_number;
    private String username;
    private String password;
}
