package com.example.ParnellAgency.services;

import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.dto.UserDto;
import com.example.ParnellAgency.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveClient(UserDto userDto) {
        Client client = new Client();
        client.setName(userDto.getFirstName() + " " + userDto.getLastName());
        client.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        client.setRoles(userDto.getRoles());
        client.setPassword(passwordEncoder.encode(userDto.getPassword()));
        clientRepository.save(client);
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map((client) -> mapToUserDto(client))
                .collect(Collectors.toList());
    }
    private UserDto mapToUserDto(Client client){
        UserDto userDto = new UserDto();
        String[] str = client.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(client.getEmail());
        userDto.setRoles(client.getRoles());
        return userDto;
    }
}

