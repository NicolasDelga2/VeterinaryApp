package com.vetApplication.program.repositories;


import com.vetApplication.program.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
