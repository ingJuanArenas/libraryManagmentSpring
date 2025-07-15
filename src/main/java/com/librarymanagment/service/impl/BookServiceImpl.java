package com.librarymanagment.service.impl;

import java.util.List;



import org.springframework.stereotype.Service;

import com.librarymanagment.model.dto.BookRequest;
import com.librarymanagment.model.dto.BookResponse;
import com.librarymanagment.model.vo.Book;
import com.librarymanagment.repository.BookRepository;
import com.librarymanagment.service.BookService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository br;

    @Override
    public List<BookResponse> getAllBooks() {
        return br.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
        return br.findById(id).map(this::toResponse).orElseThrow();
    }

    @Override
    public List<BookResponse> getByText(String title) {
        return br.getAllByName('%'+title+'%').stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public BookResponse createBook(BookRequest book) {
       var entity = toEntity(book);
        var newBook= br.save(entity);
      return toResponse(newBook) ;
    }

    @Override
    public BookResponse postStatus(Long id) {
       var entityOptional = br.findById(id);
        if(!entityOptional.isPresent()){

        }

        var entity = entityOptional.get();
        entity.setStatus("prestado");

        return toResponse(entity);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest book) {
        var entityOptional = br.findById(id);
        if(!entityOptional.isPresent()){

        }

        var entity =toEntity(book);
        entity.setId(entityOptional.get().getId());
        var updatedEntity = br.save(entity);

        return toResponse(updatedEntity);


    }

    @Override
    public void deleteBook(Long id) {
        br.deleteById(id);
    }


    private BookResponse toResponse(Book book){
        var response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setIsbn(book.getIsbn());
        response.setYear(book.getYear());
        response.setStatus(book.getStatus());

        return response;
    }

    private Book toEntity(BookRequest book){
        var entity = new Book();
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setIsbn(book.getIsbn());
        entity.setYear(book.getYear());
        entity.setStatus(book.getStatus());

        return entity;
    }
    
}
