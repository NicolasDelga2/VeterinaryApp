package com.vetApplication.program.repositories;

import com.vetApplication.program.models.Client;
import com.vetApplication.program.models.ClinicHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicHistoryRepository extends JpaRepository<ClinicHistory, Integer> {
}
