package com.sea.clients.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Phone {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "phone_id", columnDefinition = "CHAR(36)") // Map to `phone_id`
    private String id;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{10,11}$")
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference // Avoid recursion
    private Client client;

    public enum PhoneType {
        RESIDENTIAL, COMMERCIAL, CELLPHONE
    }
}