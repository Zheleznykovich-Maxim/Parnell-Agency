package com.example.OrderService.controllers;

import org.springframework.ui.Model;
import com.example.OrderService.models.Client;
import com.example.OrderService.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @GetMapping("/clients")
    public String findAll(Model model) {
        List<Client> clients = (List<Client>) clientService.findAll();
        model.addAttribute("clients", clients);
        return "index";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client) {
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }
}
