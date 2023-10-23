package com.libmanagement.librarymanagementsystem.service.patronService;

import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import com.libmanagement.librarymanagementsystem.utility.PatronNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetPatronByIdService {

    private final PatronRepository patronRepository;

    @Autowired
    public GetPatronByIdService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }
    public Patron getPatronById(Long patronId) {
        return patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
    }
}
