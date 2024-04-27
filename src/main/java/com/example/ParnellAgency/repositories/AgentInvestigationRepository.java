package com.example.ParnellAgency.repositories;

import com.example.ParnellAgency.models.AgentInvestigation;
import com.example.ParnellAgency.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgentInvestigationRepository extends JpaRepository<AgentInvestigation, Integer> {
    @Query("SELECT e FROM AgentInvestigation e WHERE " +
            "(:searchValue IS NULL OR e.ID_agent_investigation = %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.agent.ID_agent = %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.investigation.id = %:searchValue%)")
    Iterable<AgentInvestigation> searchByFields(@Param("searchValue") String searchValue);
}
