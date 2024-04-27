package com.example.ParnellAgency.controllers;

import com.example.ParnellAgency.models.Finance;
import com.example.ParnellAgency.models.Investigation;
import com.example.ParnellAgency.services.FinanceService;
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
public class FinanceController {
    private final FinanceService financeService;
    private  final InvestigationService investigationService;
    @GetMapping("/finance")
    public String findAll(Model model) {
        List<Finance> financeList = (List<Finance>) financeService.findAll();
        model.addAttribute("finance", financeList);
        return "finance/finance-index";
    }

    @GetMapping("/finance-create")
    public String createFinanceForm(Finance finance, Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("invests", investigationList);
        return "finance/finance-create";
    }

    @PostMapping("/finance-create")
    public String createFinance(Finance finance) {
        financeService.createFinance(finance);
        return "redirect:/finance";
    }

    @GetMapping("finance-update/{id}")
    public String updateFinanceForm(@PathVariable("id") int id, Model model) {
        Finance finance = financeService.findById(id);
        model.addAttribute("finance", finance);
        return "finance/finance-update";
    }

    @PostMapping("/finance-update")
    public String updateFinance(Finance finance) {
        financeService.createFinance(finance);
        return "redirect:/finance";
    }

    @GetMapping("/finance-delete/{id}")
    public String deleteFinance(@PathVariable("id") int id) {
        financeService.deleteById(id);
        return "redirect:/finance";
    }

    @GetMapping("/finance-search")
    public String searchFiance(@Param("searchValue") String searchValue, Model model) {
        List<Finance> finances = (List<Finance>) financeService.search(searchValue);
        model.addAttribute("finance", finances);
        model.addAttribute("searchValue", searchValue);
        return "finance/finance-index";
    }

}
