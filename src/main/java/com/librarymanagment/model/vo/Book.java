package com.librarymanagment.model.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "author", nullable = false)
    String author;
    @Column(name = "isbn", nullable = false)
    String isbn;
    @Column(name = "year", nullable = false)
    String year;
    @Column(name = "status", nullable = false)
    String status;

}
