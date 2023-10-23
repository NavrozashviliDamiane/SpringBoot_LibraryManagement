package com.libmanagement.librarymanagementsystem.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Entity
@Table(name = "patrons")
@Data
@NoArgsConstructor
public class Patron implements UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patron_id")
    private Long id;

    private String username;

    private String password;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "membership_status")
    private boolean membershipStatus;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "patron_roles", joinColumns = @JoinColumn(name = "patron_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}

