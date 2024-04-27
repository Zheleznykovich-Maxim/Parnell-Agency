package com.example.ParnellAgency.repositories;

import com.example.ParnellAgency.models.Agent;
import com.example.ParnellAgency.models.Evidence;
import com.example.ParnellAgency.models.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EvidenceRepository extends JpaRepository<Evidence, Integer> {
    @Query("SELECT e FROM Evidence e WHERE " +
            "(:searchValue IS NULL OR e.description LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.ID_evidence LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.agentInvestigation.ID_agent_investigation LIKE %:searchValue%)")
    Iterable<Evidence> searchByFields(@Param("searchValue") String searchValue);
}
