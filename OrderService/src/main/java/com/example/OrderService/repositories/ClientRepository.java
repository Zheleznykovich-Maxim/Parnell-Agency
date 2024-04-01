package com.example.OrderService.repositories;

import com.example.OrderService.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT e FROM Client e WHERE " +
            "(:searchValue IS NULL OR e.case_description LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.phone_number LIKE %:searchValue%)")
    Iterable<Client> searchByFields(@Param("searchValue") String searchValue);

    Iterable<Client> findByNameContaining(String name);
}
