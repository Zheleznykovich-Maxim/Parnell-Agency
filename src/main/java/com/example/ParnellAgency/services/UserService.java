package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.User;
import com.example.ParnellAgency.models.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
