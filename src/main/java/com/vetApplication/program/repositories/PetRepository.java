package com.vetApplication.program.repositories;

import com.vetApplication.program.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
