package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.services.AgentService;
import com.example.ParnellAgency.services.ClientService;
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
public class AgentController {
    private final AgentService agentService;
    @GetMapping("/agents")
    public String findAll(Model model) {
        List<Agent> agents = (List<Agent>) agentService.findAll();
        model.addAttribute("agents", agents);
        return "agent/agent-index";
    }

    @GetMapping("/agent-create")
    public String createAgentForm(Agent agent) {
        return "agent/agent-create";
    }

    @PostMapping("/agent-create")
    public String createAgent(Agent agent) {
        agentService.createAgent(agent);
        return "redirect:/agents";
    }

    @GetMapping("/agent-update/{id}")
    public String updateAgentForm(@PathVariable("id") int id, Model model) {
        Agent agent = agentService.findById(id);
        model.addAttribute("agent", agent);
        return "agent/agent-update";
    }

    @PostMapping("/agent-update")
    public String updateAgent(Agent agent) {
        agentService.createAgent(agent);
        return "redirect:/agents";
    }

    @GetMapping("/agent-delete/{id}")
    public String deleteAgent(@PathVariable("id") int id) {
        agentService.deleteById(id);
        return "redirect:/agents";
    }

    @GetMapping("/agent-search")
    public String searchAgent(@Param("searchValue") String searchValue, Model model) {
        List<Agent> agents = (List<Agent>) agentService.search(searchValue);
        model.addAttribute("agents", agents);
        model.addAttribute("searchValue", searchValue);
        return "agent/agent-index";
    }
}
