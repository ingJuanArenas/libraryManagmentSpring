package com.librarymanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.librarymanagment.model.vo.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b WHERE lower(b.title) like lower(:title)" )
    List<Book> getAllByName(String title);
    
}