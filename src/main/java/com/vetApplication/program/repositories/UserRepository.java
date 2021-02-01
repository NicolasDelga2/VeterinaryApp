package com.vetApplication.program.repositories;

import com.vetApplication.program.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
