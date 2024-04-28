package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.models.AgentInvestigation;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.Investigation;
import com.example.ParnellAgency.services.AgentInvestigationService;
import com.example.ParnellAgency.services.AgentService;
import com.example.ParnellAgency.services.ClientService;
import com.example.ParnellAgency.services.InvestigationService;
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
public class AgentInvestigationController {
    private final AgentInvestigationService agentInvestigationService;
    private final AgentService agentService;
    private final InvestigationService investigationService;
    @GetMapping("/agent-invests")
    public String findAll(Model model) {
        List<AgentInvestigation> agentInvestigations = (List<AgentInvestigation>) agentInvestigationService.findAll();
        System.out.println("ds");
        model.addAttribute("agent_invests", agentInvestigations);
        return "agent-invest/agent-invest-index";
    }

    @GetMapping("/agent-invest-create")
    public String createAgentInvestigationForm(AgentInvestigation agentInvestigation, Model model) {
        List<Agent> agents = (List<Agent>) agentService.findAll();
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("agents", agents);
        model.addAttribute("investigations", investigationList);
        return "agent-invest/agent-invest-create";
    }

    @PostMapping("/agent-invest-create")
    public String createAgentInvestigation(AgentInvestigation agentInvestigation) {
        agentInvestigationService.createAgentInvestigation(agentInvestigation);
        return "redirect:/agent-invests";
    }

    @GetMapping("/agent-invest-update/{id}")
    public String updateAgentInvestigationForm(@PathVariable("id") int id, Model model) {
        AgentInvestigation agentInvestigation = agentInvestigationService.findById(id);
        model.addAttribute("agentInvestigation", agentInvestigation);
        List<Agent> agents = (List<Agent>) agentService.findAll();
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("agents", agents);
        model.addAttribute("investigations", investigationList);
        return "agent-invest/agent-invest-update";
    }

    @PostMapping("/agent-invest-update")
    public String updateAgentInvestigation(AgentInvestigation agentInvestigation) {
        agentInvestigationService.createAgentInvestigation(agentInvestigation);
        return "redirect:/agent-invests";
    }

    @GetMapping("/agent-invest-delete/{id}")
    public String deleteAgentInvestigation(@PathVariable("id") int id) {
        agentInvestigationService.deleteById(id);
        return "redirect:/agent-invests";
    }

    @GetMapping("/agent-invest-search")
    public String searchAgentInvestigation(@Param("searchValue") String searchValue, Model model) {
        List<AgentInvestigation> agentInvestigations =
                (List<AgentInvestigation>) agentInvestigationService.search(searchValue);
        model.addAttribute("agent_invests", agentInvestigations);
        model.addAttribute("searchValue", searchValue);
        return "agent-invest/agent-invest-index";
    }
}
