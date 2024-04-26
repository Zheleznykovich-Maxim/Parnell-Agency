package com.example.ParnellAgency.models;

import com.example.ParnellAgency.models.enums.AgentRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_agent;
    private String username;
    @Column(name = "prof. experience")
    private int prof_experience;
    @Enumerated(EnumType.STRING)
    private AgentRole agent_role;
}
