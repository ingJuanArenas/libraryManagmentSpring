package com.librarymanagment.service;

import java.util.List;

import com.librarymanagment.model.dto.BookRequest;
import com.librarymanagment.model.dto.BookResponse;


public interface BookService {
List<BookResponse> getAllBooks();
BookResponse getBookById(Long id);
List<BookResponse> getByText (String text);

BookResponse createBook(BookRequest book);
BookResponse postStatus(Long id);

BookResponse updateBook(Long id, BookRequest book);

void deleteBook(Long id);

} 

/*
 * 
 * 

    
    

    
}

 */