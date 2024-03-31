package com.example.OrderService.services;

import com.example.OrderService.models.Client;
import com.example.OrderService.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


}
