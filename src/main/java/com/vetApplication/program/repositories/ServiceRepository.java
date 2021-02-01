package com.vetApplication.program.repositories;

import com.vetApplication.program.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
