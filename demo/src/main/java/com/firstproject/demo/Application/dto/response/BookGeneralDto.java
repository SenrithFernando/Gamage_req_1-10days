package com.firstproject.demo.Application.dto.response;

import lombok.Data;

@Data
public class BookGeneralDto {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Integer publishedYear;
    private String coverUrl;
}
