package com.example.ParnellAgency.models;

import com.example.ParnellAgency.models.enums.AgentRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_agent;
    @NotNull
    @Size(min=3, max=30)
    private String username;
    @NotNull
    @Column(name = "prof. experience")
    @Min(1)
    private int prof_experience;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AgentRole agent_role;
}
