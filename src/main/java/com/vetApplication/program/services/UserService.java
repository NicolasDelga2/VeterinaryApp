package com.vetApplication.program.services;


import com.vetApplication.program.models.User;
import com.vetApplication.program.repositories.UserRepository;
import com.vetApplication.program.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static com.vetApplication.program.security.ApplicationUserRole.ADMIN;
import static com.vetApplication.program.security.ApplicationUserRole.EMPLEADO;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        /* return new org.springframework.security.core.userdetails.User(user.getUsername(),
                passwordEncoder.encode(user.getPassword()),true,
                true,true,true,
                ADMIN.getGrantedAuthorities());*/
        return new MyUserDetails(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
       userRepository.save(user);
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }

}
