package com.firstproject.demo.Application.dto.request;

import lombok.Data;

@Data
public class CreateBookDto {
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Integer publishedYear;
}
