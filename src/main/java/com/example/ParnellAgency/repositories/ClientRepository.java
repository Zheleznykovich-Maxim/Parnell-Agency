package com.example.ParnellAgency.repositories;

import com.example.ParnellAgency.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT e FROM Client e WHERE " +
            "(:searchValue IS NULL OR e.name LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.email LIKE %:searchValue%)" +
            " OR (:searchValue IS NULL OR e.id LIKE %:searchValue%)")
    Iterable<Client> searchByFields(@Param("searchValue") String searchValue);

    Iterable<Client> findByNameContaining(String name);
    Client findByEmail(String email);
}
