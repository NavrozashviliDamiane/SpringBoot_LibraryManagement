package com.libmanagement.librarymanagementsystem.repository;

import com.libmanagement.librarymanagementsystem.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatronRepository extends JpaRepository<Patron, Long> {
    // Custom Query Method: Find patrons by first name
    List<Patron> findByFirstName(String firstName);

    // Custom Query Method: Find patrons by last name
    List<Patron> findByLastName(String lastName);

    // Custom Query Method: Find patrons by membership status
    List<Patron> findByMembershipStatus(boolean membershipStatus);

    List<Patron> findByContactInfo(String contactInfo);


    // Custom Query Method: Find all patrons and sort by first name in ascending order
    List<Patron> findAllByOrderByFirstNameAsc();

    // Custom Query Method: Find all patrons and sort by last name in ascending order
    List<Patron> findAllByOrderByLastNameAsc();

    Patron findByUsername(String username);
}
