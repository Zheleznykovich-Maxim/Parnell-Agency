package com.example.OrderService.services;

import com.example.OrderService.models.Finance;
import com.example.OrderService.models.Investigation;
import com.example.OrderService.repositories.FinanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinanceService {
    private final FinanceRepository financeRepository;

    public Iterable<Finance> findAll() {
        return financeRepository.findAll();
    }

    public void createFinance(Finance finance) {
        financeRepository.save(finance);
    }

    public Finance findById(int id) {
        return financeRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        financeRepository.deleteById(id);
    }

    public Iterable<Finance> search(String searchValue) {
        return  financeRepository.searchByFields(searchValue);
    }
}
