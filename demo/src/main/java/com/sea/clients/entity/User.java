package com.sea.clients.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "CHAR(36)") // Map to `user_id` column
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Client> clients;

    @CreationTimestamp
    @Column(name = "created_at") 
    private LocalDateTime createdAt;

    public enum Role {
        ADMIN, STANDARD
    }
}