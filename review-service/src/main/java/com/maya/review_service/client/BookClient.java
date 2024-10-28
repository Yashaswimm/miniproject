package com.maya.review_service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;

@FeignClient(name = "book-service", url = "http://book-sr:8081/api/booksrv")
public interface BookClient {
    @GetMapping("/books/{bid}")
    Book getBookById(@PathVariable("bid") int bookId);
}
