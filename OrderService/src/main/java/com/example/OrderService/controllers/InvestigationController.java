package com.example.OrderService.controllers;

import com.example.OrderService.models.Investigation;
import com.example.OrderService.services.InvestigationService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class InvestigationController {
    private final InvestigationService investigationService;

    @GetMapping("/invests")
    private String findAll(Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("invests", investigationList);
        return "investigation/invest-index";
    }

    @GetMapping("/invest-create")
    private String createInvestigationForm(Investigation investigation) {
        return "investigation/invest-create";
    }

    @PostMapping("/invest-create")
    private String createInvest(Investigation investigation) {
        investigationService.createInvestigation(investigation);
        return "redirect:/invests";
    }

    @GetMapping("/invest-update/{id}")
    private String updateInvestigationForm(@PathVariable("id") int id, Model model) {
        Investigation investigation = investigationService.findById(id);
        model.addAttribute("investigation", investigation);
        return "investigation/invest-update";
    }

    @PostMapping("/invest-update")
    private String updateInvestigation(Investigation investigation) {
        investigationService.createInvestigation(investigation);
        return "redirect:/invests";
    }

    @GetMapping("/invest-delete/{id}")
    private String deleteInvest(@PathVariable("id") int id) {
        investigationService.deleteById(id);
        return "redirect:/invests";
    }

    @GetMapping("/invest-search")
    private String searchInvest(@Param("searchValue") String searchValue, Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.search(searchValue);
        model.addAttribute("invests", investigationList);
        model.addAttribute("searchValue", searchValue);
        return "investigation/invest-index";
    }
}
