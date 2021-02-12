package com.vetApplication.program.repositories;

import com.vetApplication.program.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
