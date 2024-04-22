package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.Investigation;
import com.example.ParnellAgency.repositories.InvestigationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvestigationService {
    private final InvestigationRepository investigationRepository;

    public Iterable<Investigation> findAll() {
        return investigationRepository.findAll();
    }

    public void createInvestigation(Investigation investigation) {
        investigationRepository.save(investigation);
    }

    public Investigation findById(int id) {
        return investigationRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        investigationRepository.deleteById(id);
    }

    public Iterable<Investigation> search(String searchValue) {
        return  investigationRepository.searchByFields(searchValue);
    }
}