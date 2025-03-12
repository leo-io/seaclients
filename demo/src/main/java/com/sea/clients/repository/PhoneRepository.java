package com.sea.clients.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.clients.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}