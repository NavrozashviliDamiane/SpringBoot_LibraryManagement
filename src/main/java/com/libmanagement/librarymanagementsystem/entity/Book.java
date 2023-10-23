package com.libmanagement.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "genre")
    private String genre;

    @Column(name = "availability")
    private boolean availability;
}
