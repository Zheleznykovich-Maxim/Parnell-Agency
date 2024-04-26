package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.repositories.AgentRepository;
import com.example.ParnellAgency.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgentService {
    private final AgentRepository agentRepository;

    public Iterable<Agent> findAll() {
        return agentRepository.findAll();
    }

    public void createAgent(Agent agent) {
        agentRepository.save(agent);
    }

    public Agent findById(int id) {
        return agentRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        agentRepository.deleteById(id);
    }

    public Iterable<Agent> search(String searchValue) {
        return agentRepository.searchByFields(searchValue);
    }
}
