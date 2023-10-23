package com.libmanagement.librarymanagementsystem.service.patronService;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import com.libmanagement.librarymanagementsystem.utility.PatronNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DeletePatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public DeletePatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }
    @Transactional
    public void deletePatron(Long patronId) {
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
        patronRepository.delete(patron);
    }
}
