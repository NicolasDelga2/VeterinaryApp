package com.vetApplication.program.repositories;


import com.vetApplication.program.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
