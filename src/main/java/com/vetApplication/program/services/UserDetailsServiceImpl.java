package com.vetApplication.program.services;


import com.vetApplication.program.models.User;
import com.vetApplication.program.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl {

    @Autowired private UserRepository userRepository;

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
