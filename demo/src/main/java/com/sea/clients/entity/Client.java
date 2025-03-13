package com.sea.clients.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "client_id", columnDefinition = "CHAR(36)") // Map to `client_id` column
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\d{11}$", message = "CPF must be 11 digits")
    private String cpf;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{8}$", message = "CEP must be 8 digits")
    private String cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Z]{2}$", message = "State must be 2 uppercase letters")
    private String state;

    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    @JsonIgnore // Prevents infinite recursion
    private User user;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;
    
    @CreationTimestamp
    @Column(name = "created_at") 
    private LocalDateTime createdAt;
}