package com.example.ParnellAgency.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "client/client-index";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client) {
        return "client/client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{id}")
    public String updateClientForm(@PathVariable("id") int id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client/client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/client-delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }

//    @GetMapping("/client-search/{id}")
//    public String searchClient(@PathVariable("id") int id) {
//        Client client = clientService.findById(id);
//
//    }

    @GetMapping("/client-search")
    public String searchClient(@Param("searchValue") String searchValue, Model model) {
        List<Client> clients = (List<Client>) clientService.search(searchValue);
        model.addAttribute("clients", clients);
        model.addAttribute("searchValue", searchValue);
        return "client/client-index";
    }
}
