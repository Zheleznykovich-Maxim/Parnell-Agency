package com.example.ParnellAgency.services;

import com.example.ParnellAgency.config.MyUserDetails;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.repositories.ClientRepository;
import com.example.ParnellAgency.repositories.UserRepository;

import com.example.ParnellAgency.models.User;
import com.example.ParnellAgency.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    public CustomUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);

        if (client != null) {
            MyUserDetails userDetails = new MyUserDetails(client);
            return new org.springframework.security.core.userdetails.User(client.getEmail(),
                    client.getPassword(),
                    userDetails.getAuthorities());
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

}