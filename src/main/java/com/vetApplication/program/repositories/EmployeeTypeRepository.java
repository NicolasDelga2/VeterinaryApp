package com.vetApplication.program.repositories;

import com.vetApplication.program.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
}
