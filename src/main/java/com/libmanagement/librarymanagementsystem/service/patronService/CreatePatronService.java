package com.libmanagement.librarymanagementsystem.service.patronService;

import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CreatePatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public CreatePatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Transactional
    public Patron createPatron(Patron patron) {


        // No patron with the same contact info found, so you can save the new patron
        return patronRepository.save(patron);
    }

}
