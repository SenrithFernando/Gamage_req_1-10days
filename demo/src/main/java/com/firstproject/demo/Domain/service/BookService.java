package com.firstproject.demo.Domain.service;

import com.firstproject.demo.Application.dto.request.CreateBookDto;
import com.firstproject.demo.Application.dto.response.BookGeneralDto;
import com.firstproject.demo.Domain.entity.Book;
import com.firstproject.demo.Domain.exception.BookNotFoundException;
import com.firstproject.demo.External.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public ResponseEntity<BookGeneralDto> getBook(Integer id){
        BookGeneralDto bookGeneralDto = new BookGeneralDto();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            bookGeneralDto.setId(book.getId());
            bookGeneralDto.setTitle(book.getTitle());
            bookGeneralDto.setAuthor(book.getAuthor());
            bookGeneralDto.setIsbn(book.getIsbn());
            bookGeneralDto.setCategory(book.getCategory());
            bookGeneralDto.setPublishedYear(book.getPublishedYear());
            return ResponseEntity.ok(bookGeneralDto);
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }

    public ResponseEntity<List<BookGeneralDto>> getAllBook() {
        List<Book> books = bookRepository.findAll();
        List<BookGeneralDto> bookGeneralDtos = books.stream().map(book -> {
            BookGeneralDto bookGeneralDto = new BookGeneralDto();
            bookGeneralDto.setId(book.getId());
            bookGeneralDto.setTitle(book.getTitle());
            bookGeneralDto.setAuthor(book.getAuthor());
            bookGeneralDto.setIsbn(book.getIsbn());
            bookGeneralDto.setCategory(book.getCategory());
            bookGeneralDto.setPublishedYear(book.getPublishedYear());
            return bookGeneralDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(bookGeneralDtos);
    }

    public ResponseEntity<Book> addBook(CreateBookDto createBookDto) {
        Book book = new Book();
        book.setTitle(createBookDto.getTitle());
        book.setAuthor(createBookDto.getAuthor());
        book.setIsbn(createBookDto.getIsbn());
        book.setCategory(createBookDto.getCategory());
        book.setPublishedYear(createBookDto.getPublishedYear());
        bookRepository.save(book);
        ResponseEntity<Book> responseEntity = ResponseEntity.ok(book);
        return responseEntity;
    }

    public ResponseEntity<String> deleteBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book deleted Successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateBook(Integer id, String newTitle) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            log.info("Book found and the id is {}", id);
            Book book = optionalBook.get();
            book.setTitle(newTitle);
            bookRepository.save(book);
            return ResponseEntity.ok("Book updated successfully");
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }
}
