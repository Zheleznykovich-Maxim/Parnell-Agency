package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.AgentInvestigation;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.repositories.AgentInvestigationRepository;
import com.example.ParnellAgency.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgentInvestigationService {
    private final AgentInvestigationRepository agentInvestigationRepository;

    public Iterable<AgentInvestigation> findAll() {
        return agentInvestigationRepository.findAll();
    }

    public void createAgentInvestigation(AgentInvestigation agentInvestigation) {
        agentInvestigationRepository.save(agentInvestigation);
    }

    public AgentInvestigation findById(int id) {
        return agentInvestigationRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        agentInvestigationRepository.deleteById(id);
    }

    public Iterable<AgentInvestigation> search(String searchValue) {
        return agentInvestigationRepository.searchByFields(searchValue);
    }
}
