package com.libmanagement.librarymanagementsystem.repository;

import com.libmanagement.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);

    List<Book> findByIsbn(String isbn);
    List<Book> findByAvailability(boolean availability);

    // Custom Query Method: Find books by genre and sort by title
    List<Book> findByGenreOrderByTitleAsc(String genre);

    // Custom Query Method: Find books by author and sort by publication year
    List<Book> findByAuthorOrderByTitleDesc(String author);


    // Custom Query Method: Find books by title and sort by title in descending order
    List<Book> findByTitleOrderByTitleDesc(String title);

    // Custom Query Method: Find books by availability and sort by title
    List<Book> findByAvailabilityOrderByTitleAsc(boolean availability);
}
