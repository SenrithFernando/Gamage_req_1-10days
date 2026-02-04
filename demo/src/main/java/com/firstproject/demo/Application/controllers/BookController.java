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
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("/getBook")
    public ResponseEntity<BookGeneralDto> getBook(@RequestParam Integer id){
        return bookService.getBook(id);
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<java.util.List<BookGeneralDto>> getAllBook(){
        return bookService.getAllBook();
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
    public ResponseEntity<String> updateBook(@RequestParam Integer id, @RequestBody CreateBookDto updateDto){
        return bookService.updateBook(id, updateDto);
    }
}
