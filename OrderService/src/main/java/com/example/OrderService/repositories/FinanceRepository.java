package com.example.OrderService.repositories;

import com.example.OrderService.models.Finance;
import com.example.OrderService.models.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {
    @Query("SELECT e FROM Finance e WHERE " +
            "(:searchValue IS NULL OR e.recipient_account LIKE %:searchValue%)")
    Iterable<Finance> searchByFields(@Param("searchValue") String searchValue);


}
