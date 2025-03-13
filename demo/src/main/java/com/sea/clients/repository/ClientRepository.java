package com.sea.clients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.clients.entity.Client;
import com.sea.clients.entity.User;

public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findByUser(User user); 
}