package com.example.ParnellAgency.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_client")
    private Long id;
    @NotNull
    @Size(min = 3, max = 60)
    private String name;
    @NotNull
    @Column(unique=true)
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String roles;
}
