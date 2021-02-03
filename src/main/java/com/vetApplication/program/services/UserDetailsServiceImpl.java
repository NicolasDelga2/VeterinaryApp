package com.vetApplication.program.services;


import com.vetApplication.program.models.User;
import com.vetApplication.program.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), true,true,true, true,
                buildGrante(user.getRol()));
    }

    public List<GrantedAuthority> buildGrante(byte rol){
        String[] roles = {"LECTOR", "USUARIO", "ADMINISTRADOR"};
        List<GrantedAuthority> auths = new ArrayList<>();

        for(int i = 0; i < rol; i++){
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }
}
