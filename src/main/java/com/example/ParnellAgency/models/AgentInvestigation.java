package com.example.ParnellAgency.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "agent-investigation")
public class AgentInvestigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_agent_investigation;

    @ManyToOne
    @JoinColumn(name = "ID_investigation")
    private Investigation investigation;

    @ManyToOne
    @JoinColumn(name = "ID_agent")
    private Agent agent;
}
