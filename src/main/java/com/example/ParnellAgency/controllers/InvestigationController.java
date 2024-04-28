package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.config.MyUserDetails;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.Investigation;
import com.example.ParnellAgency.services.ClientService;
import com.example.ParnellAgency.services.InvestigationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class InvestigationController {
    private final InvestigationService investigationService;
    private final ClientService clientService;
    @GetMapping("/invests")
    public String findAll(Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("invests", investigationList);
        return "investigation/invest-index";
    }
    @GetMapping("/my-invests")
    public String findMyInvests(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Client client = clientService.findByEmail(userDetails.getUsername());
        List<Investigation> investigationList = (List<Investigation>) investigationService.findByClientId(client.getId());
        model.addAttribute("invests", investigationList);
        return "investigation/invest-index";
    }

    @GetMapping("/invest-create")
    private String createInvestigationForm(@AuthenticationPrincipal UserDetails userDetails, Investigation investigation, Model model) {
        Client client = clientService.findByEmail(userDetails.getUsername());
        model.addAttribute("client", client);
        return "investigation/invest-create";
    }

    @PostMapping("/invest-create")
    private String createInvest(Investigation investigation) {
        investigationService.createInvestigation(investigation);
        return "redirect:/invests";
    }

    @GetMapping("/invest-update/{id}")
    public String updateInvestigationForm(@PathVariable("id") int id, Model model) {
        Investigation investigation = investigationService.findById(id);
        model.addAttribute("investigation", investigation);
        return "investigation/invest-update";
    }

    @PostMapping("/invest-update")
    public String updateInvestigation(Investigation investigation) {
        investigationService.createInvestigation(investigation);
        return "redirect:/invests";
    }

    @GetMapping("/invest-delete/{id}")
    public String deleteInvest(@PathVariable("id") int id) {
        investigationService.deleteById(id);
        return "redirect:/invests";
    }

    @GetMapping("/invest-search")
    public String searchInvest(@Param("searchValue") String searchValue, Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.search(searchValue);
        model.addAttribute("invests", investigationList);
        model.addAttribute("searchValue", searchValue);
        return "investigation/invest-index";
    }


}
