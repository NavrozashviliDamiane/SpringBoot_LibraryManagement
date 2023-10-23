package com.libmanagement.librarymanagementsystem.service.bookService;

import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FindBookService {



    private BookRepository bookRepository;

    @Autowired
    public FindBookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> findByAvailability(boolean availability) {
        return bookRepository.findByAvailability(availability);
    }
    public List<Book> findByGenreOrderByTitleAsc(String genre) {
        return bookRepository.findByGenreOrderByTitleAsc(genre);
    }
    public List<Book> findByAuthorOrderByTitleDesc(String author) {
        return bookRepository.findByAuthorOrderByTitleDesc(author);
    }
    public List<Book> findByTitleOrderByTitleDesc(String title) {
        return bookRepository.findByTitleOrderByTitleDesc(title);
    }
    public List<Book> findByAvailabilityOrderByTitleAsc(boolean availability) {
        return bookRepository.findByAvailabilityOrderByTitleAsc(availability);
    }

}