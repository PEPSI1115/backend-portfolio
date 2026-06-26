package com.hyunmin.portfolio.practice.repository;

import com.hyunmin.portfolio.practice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}