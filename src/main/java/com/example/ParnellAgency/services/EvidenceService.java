package com.example.ParnellAgency.services;


import com.example.ParnellAgency.models.Evidence;
import com.example.ParnellAgency.repositories.EvidenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EvidenceService {
    private final EvidenceRepository evidenceRepository;

    public Iterable<Evidence> findAll() {
        return evidenceRepository.findAll();
    }

    public void createClient(Evidence evidence) {
        evidenceRepository.save(evidence);
    }

    public Evidence findById(int id) {
        return evidenceRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        evidenceRepository.deleteById(id);
    }

    public Iterable<Evidence> search(String searchValue) {
        return evidenceRepository.searchByFields(searchValue);
    }
}
