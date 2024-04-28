package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.services.AgentService;
import com.example.ParnellAgency.services.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String createAgent(@Valid Agent agent, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "agent/agent-create";
        }
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
    public String updateAgent(@Valid Agent agent, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "agent/agent-update";
        }
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
