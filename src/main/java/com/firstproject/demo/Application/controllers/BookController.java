package com.firstproject.demo.Application.controllers;

import com.firstproject.demo.Application.dto.request.CreateBookDto;
import com.firstproject.demo.Application.dto.response.BookGeneralDto;
import com.firstproject.demo.Domain.entity.Book;
import com.firstproject.demo.Domain.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("/getBook")
    public ResponseEntity<BookGeneralDto> getBook(@RequestParam Integer id){
        return bookService.getBook(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody CreateBookDto createBookDto){
        return bookService.addBook(createBookDto);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam Integer id){
        return bookService.deleteBook(id);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestParam Integer id, @RequestParam String newTitle){
        return bookService.updateBook(id,newTitle);
    }
}
