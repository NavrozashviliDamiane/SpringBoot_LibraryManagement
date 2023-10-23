package com.libmanagement.librarymanagementsystem.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "librarians")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian implements UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarian_id")
    private Long id;



    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_info")
    private String contactInfo;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "librarian_roles", joinColumns = @JoinColumn(name = "librarian_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


}
