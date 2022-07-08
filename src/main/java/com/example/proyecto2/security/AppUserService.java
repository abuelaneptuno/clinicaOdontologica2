package com.example.proyecto2.security;

import com.example.proyecto2.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

public class AppUserService implements UserDetailsService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //return userRepository.findByUsername(username).get();

        Optional<AppUser> userRes = userRepository.findByUsername(username);
        AppUser user = userRes.get();
        return new User(
                username,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getAppUsuarioRoles().toString())));
    }
}
