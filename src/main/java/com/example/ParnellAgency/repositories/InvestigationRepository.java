package com.example.ParnellAgency.repositories;

import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InvestigationRepository  extends JpaRepository<Investigation, Integer> {
    @Query("SELECT e FROM Investigation e WHERE " +
            "(:searchValue IS NULL OR e.specification LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.id LIKE %:searchValue%)")
    Iterable<Investigation> searchByFields(@Param("searchValue") String searchValue);

    @Query("SELECT e FROM Investigation e WHERE " +
            "(:clientId IS NULL OR e.client.id = %:clientId%)")
    Iterable<Investigation> findByClientId(@Param("clientId") Long clientId);
}
