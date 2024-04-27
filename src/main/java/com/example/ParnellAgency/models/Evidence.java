package com.example.ParnellAgency.models;

import com.example.ParnellAgency.models.enums.EvidenceType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_evidence;
    private String description;
    @Enumerated(EnumType.STRING)
    private EvidenceType evidence_type;

    @ManyToOne
    @JoinColumn(name = "ID_agent_investigation")
    private AgentInvestigation agentInvestigation;
}
