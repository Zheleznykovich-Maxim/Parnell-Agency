package com.example.OrderService.repositories;

import com.example.OrderService.models.Client;
import com.example.OrderService.models.Investigation;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvestigationRepository  extends JpaRepository<Investigation, Integer> {
    @Query("SELECT e FROM Investigation e WHERE " +
            "(:searchValue IS NULL OR e.specification LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.id LIKE %:searchValue%)")
    Iterable<Investigation> searchByFields(@Param("searchValue") String searchValue);
}
