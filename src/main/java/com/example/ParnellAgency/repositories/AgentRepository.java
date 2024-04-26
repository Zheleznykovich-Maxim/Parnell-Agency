package com.example.ParnellAgency.repositories;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    @Query("SELECT e FROM Agent e WHERE " +
            "(:searchValue IS NULL OR e.username LIKE %:searchValue%)" +
            "   OR (:searchValue IS NULL OR e.id LIKE %:searchValue%)")
    Iterable<Agent> searchByFields(@Param("searchValue") String searchValue);
}
