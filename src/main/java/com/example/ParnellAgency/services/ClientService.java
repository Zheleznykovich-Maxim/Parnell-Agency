package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    public Iterable<Client> search(String searchValue) {
        return clientRepository.searchByFields(searchValue);
    }
    public Iterable<Client> findByName(String name) {
//        return clientRepository.searchByFields(searchValue);
        return clientRepository.findByNameContaining(name);
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
