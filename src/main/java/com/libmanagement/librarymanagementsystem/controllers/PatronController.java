package com.libmanagement.librarymanagementsystem.controllers;

import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.service.patronService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronController {

    private final FindPatronService findPatronService;
    private final CreatePatronService createPatronService;
    private final DeletePatronService deletePatronService;
    private final GetPatronByIdService getPatronByIdService;
    private final UpdatePatronService updatePatronService;

    @Autowired
    public PatronController(FindPatronService findPatronService, CreatePatronService createPatronService,
                            DeletePatronService deletePatronService, GetPatronByIdService getPatronByIdService,
                            UpdatePatronService updatePatronService) {
        this.findPatronService = findPatronService;
        this.createPatronService = createPatronService;
        this.deletePatronService = deletePatronService;
        this.getPatronByIdService = getPatronByIdService;
        this.updatePatronService = updatePatronService;
    }

    @GetMapping("/{patronId}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long patronId) {
        Patron patron = getPatronByIdService.getPatronById(patronId);
        if (patron != null) {
            return ResponseEntity.ok(patron);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Patron> getAllPatrons() {
        return findPatronService.getAllPatrons();
    }

    @GetMapping("/first-name/{firstName}")
    public List<Patron> getPatronsByFirstName(@PathVariable String firstName) {
        return findPatronService.getPatronsByFirstName(firstName);
    }

    @GetMapping("/last-name/{lastName}")
    public List<Patron> getPatronsByLastName(@PathVariable String lastName) {
        return findPatronService.getPatronsByLastName(lastName);
    }

    @GetMapping("/membership-status/{membershipStatus}")
    public List<Patron> getPatronsByMembershipStatus(@PathVariable boolean membershipStatus) {
        return findPatronService.getPatronsByMembershipStatus(membershipStatus);
    }

    @GetMapping("/contact-info/{contactInfo}")
    public List<Patron> getPatronsByContactInfo(@PathVariable String contactInfo) {
        return findPatronService.getPatronsByContactInfo(contactInfo);
    }

    @GetMapping("/sorted-first-name")
    public List<Patron> getAllPatronsSortedByFirstNameAsc() {
        return findPatronService.getAllPatronsSortedByFirstNameAsc();
    }

    @GetMapping("/sorted-last-name")
    public List<Patron> getAllPatronsSortedByLastNameAsc() {
        return findPatronService.getAllPatronsSortedByLastNameAsc();
    }

    @PostMapping("/create")
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        Patron createdPatron = createPatronService.createPatron(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatron);
    }

    @PutMapping("/{patronId}")
    public ResponseEntity<Patron> updatePatron(
            @PathVariable Long patronId,
            @RequestBody Patron patron
    ) {
        Patron updatedPatron = updatePatronService.updatePatron(patronId, patron);
        if (updatedPatron != null) {
            return ResponseEntity.ok(updatedPatron);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{patronId}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long patronId) {
        deletePatronService.deletePatron(patronId);
        return ResponseEntity.noContent().build();
    }
}
