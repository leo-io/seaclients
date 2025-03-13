package com.sea.clients.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.clients.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);
}