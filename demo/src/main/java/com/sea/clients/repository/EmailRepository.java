package com.sea.clients.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.clients.entity.Email;

public interface EmailRepository extends JpaRepository<Email, String> {
}