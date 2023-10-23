package com.libmanagement.librarymanagementsystem.service.patronService;

import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.utility.PatronNotFoundException;
import com.libmanagement.librarymanagementsystem.utility.PatronNotUniqueException;

import java.util.List;
@Service
public class FindPatronService {


    @Autowired
    private PatronRepository patronRepository;
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }
    public Patron getPatronById(Long patronId) {
        return patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
    }
    public List<Patron> getPatronsByFirstName(String firstName) {
        return patronRepository.findByFirstName(firstName);
    }
    public List<Patron> getPatronsByLastName(String lastName) {
        return patronRepository.findByLastName(lastName);
    }
    public List<Patron> getPatronsByMembershipStatus(boolean membershipStatus) {
        return patronRepository.findByMembershipStatus(membershipStatus);
    }
    public List<Patron> getPatronsByContactInfo(String contactInfo) {
        return patronRepository.findByContactInfo(contactInfo);
    }
    public List<Patron> getAllPatronsSortedByFirstNameAsc() {
        return patronRepository.findAllByOrderByFirstNameAsc();
    }
    public List<Patron> getAllPatronsSortedByLastNameAsc() {
        return patronRepository.findAllByOrderByLastNameAsc();
    }
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }
    public Patron updatePatron(Long patronId, Patron updatedPatron) {
        Patron existingPatron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
        existingPatron.setFirstName(updatedPatron.getFirstName());
        existingPatron.setLastName(updatedPatron.getLastName());
        existingPatron.setContactInfo(updatedPatron.getContactInfo());
        existingPatron.setMembershipStatus(updatedPatron.isMembershipStatus());
        return patronRepository.save(existingPatron);
    }
    public void deletePatron(Long patronId) {
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
        patronRepository.delete(patron);
    }
}
