package com.librarymanagment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagment.model.dto.BookRequest;
import com.librarymanagment.model.dto.BookResponse;
import com.librarymanagment.service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RequestMapping("/api")  // Agregado el slash inicial
@RestController
public class BookController {

    private final BookService bs;

    // Endpoint raíz para testing
    @GetMapping("/")
    public String home() {
        return "Library Management API - Funcionando correctamente";
    }

    @GetMapping("/libros")
    public List<BookResponse> getAllBooks() {
        return bs.getAllBooks();
    }

    @GetMapping("/libros/{id}")
    public BookResponse getBookById(@PathVariable long id) {
        return bs.getBookById(id);
    }
    
    // Corregido: usar @RequestParam en lugar de @PathVariable
    @GetMapping("/buscar")
    public List<BookResponse> getByText(@RequestParam("q") String title) {
        return bs.getByText(title);
    }

    @PostMapping("/libros")  // Agregado el path específico
    public BookResponse createBook(@RequestBody BookRequest book) {
        return bs.createBook(book);
    }
    
    @PostMapping("/libros/{id}/prestar")
    public BookResponse postStatus(@PathVariable Long id) {        
        return bs.postStatus(id);
    }
    
    @PutMapping("/libros/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest book) {        
        return bs.updateBook(id, book);
    }

    @DeleteMapping("/libros/{id}")
    public void deleteBookById(@PathVariable long id){
        bs.deleteBook(id);
    }
}