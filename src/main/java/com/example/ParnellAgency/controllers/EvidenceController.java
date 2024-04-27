package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.models.*;
import com.example.ParnellAgency.services.AgentInvestigationService;
import com.example.ParnellAgency.services.AgentService;
import com.example.ParnellAgency.services.ClientService;
import com.example.ParnellAgency.services.EvidenceService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class EvidenceController {
    private final EvidenceService evidenceService;
    private final AgentInvestigationService agentInvestigationService;
    @GetMapping("/evidence")
    public String findAll(Model model) {
        List<Evidence> evidence = (List<Evidence>) evidenceService.findAll();
        model.addAttribute("evidence", evidence);
        return "evidence/evidence-index";
    }

    @GetMapping("/evidence-create")
    public String createEvidenceForm(Evidence evidence, Model model) {
        List<AgentInvestigation> agentInvestigations = (List<AgentInvestigation>) agentInvestigationService.findAll();
        model.addAttribute("agent_invests", agentInvestigations);
        return "evidence/evidence-create";
    }

    @PostMapping("/evidence-create")
    public String createEvidence(Evidence evidence) {
        evidenceService.createClient(evidence);
        return "redirect:/evidence";
    }

    @GetMapping("/evidence-update/{id}")
    public String updateEvidenceForm(@PathVariable("id") int id, Model model) {
        Evidence evidence = evidenceService.findById(id);
        model.addAttribute("evidence", evidence);
        List<AgentInvestigation> agentInvestigations = (List<AgentInvestigation>) agentInvestigationService.findAll();
        model.addAttribute("agent_invests", agentInvestigations);
        return "evidence/evidence-update";
    }

    @PostMapping("/evidence-update")
    public String updateEvidence(Evidence evidence) {
        evidenceService.createClient(evidence);
        return "redirect:/evidence";
    }

    @GetMapping("/evidence-delete/{id}")
    public String deleteEvidence(@PathVariable("id") int id) {
        evidenceService.deleteById(id);
        return "redirect:/evidence";
    }

    @GetMapping("/evidence-search")
    public String searchEvidence(@Param("searchValue") String searchValue, Model model) {
        List<Evidence> evidence = (List<Evidence>) evidenceService.search(searchValue);
        model.addAttribute("evidence", evidence);
        model.addAttribute("searchValue", searchValue);
        return "evidence/evidence-index";
    }

}
