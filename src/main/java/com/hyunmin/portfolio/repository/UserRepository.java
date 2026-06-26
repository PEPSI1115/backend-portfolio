package com.hyunmin.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hyunmin.portfolio.domain.User;
public interface UserRepository extends JpaRepository<User, Long> {
}