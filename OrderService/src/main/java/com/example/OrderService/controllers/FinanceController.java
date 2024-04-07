package com.example.OrderService.controllers;

import com.example.OrderService.models.Finance;
import com.example.OrderService.models.Investigation;
import com.example.OrderService.services.FinanceService;
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
public class FinanceController {
    private final FinanceService financeService;
    private  final InvestigationService investigationService;
    @GetMapping("/finance")
    private String findAll(Model model) {
        List<Finance> financeList = (List<Finance>) financeService.findAll();
        model.addAttribute("finance", financeList);
        return "finance/finance-index";
    }

    @GetMapping("/finance-create")
    private String createFinanceForm(Finance finance, Model model) {
        List<Investigation> investigationList = (List<Investigation>) investigationService.findAll();
        model.addAttribute("invests", investigationList);
        return "finance/finance-create";
    }

    @PostMapping("/finance-create")
    private String createFinance(Finance finance) {
        financeService.createFinance(finance);
        return "redirect:/finance";
    }

    @GetMapping("finance-update/{id}")
    private String updateFinanceForm(@PathVariable("id") int id, Model model) {
        Finance finance = financeService.findById(id);
        model.addAttribute("finance", finance);
        return "finance/finance-update";
    }

    @PostMapping("/finance-update")
    private String updateFinance(Finance finance) {
        financeService.createFinance(finance);
        return "redirect:/finance";
    }

    @GetMapping("/finance-delete/{id}")
    private String deleteFinance(@PathVariable("id") int id) {
        financeService.deleteById(id);
        return "redirect:/finance";
    }

    @GetMapping("/finance-search")
    private String searchFiance(@Param("searchValue") String searchValue, Model model) {
        List<Finance> finances = (List<Finance>) financeService.search(searchValue);
        model.addAttribute("finance", finances);
        model.addAttribute("searchValue", searchValue);
        return "finance/finance-index";
    }

}
