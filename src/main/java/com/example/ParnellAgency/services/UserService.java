package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveClient(UserDto userDto);

    Client findClientByEmail(String email);

    List<UserDto> findAllClients();
}
