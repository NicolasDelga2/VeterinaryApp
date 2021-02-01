package com.vetApplication.program.repositories;

import com.vetApplication.program.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn, Integer> {
}
