package com.libmanagement.librarymanagementsystem.service.patronService;

import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import com.libmanagement.librarymanagementsystem.utility.PatronNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UpdatePatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public UpdatePatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Transactional
    public Patron updatePatron(Long patronId, Patron updatedPatron) {
        Patron existingPatron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
        // Update patron details
        existingPatron.setFirstName(updatedPatron.getFirstName());
        existingPatron.setLastName(updatedPatron.getLastName());
        existingPatron.setContactInfo(updatedPatron.getContactInfo());
        existingPatron.setMembershipStatus(updatedPatron.isMembershipStatus());
        // Save the updated patron
        return patronRepository.save(existingPatron);
    }
}
