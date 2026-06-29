package com.example.E_Libarary.controller;


import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.enums.BookFilterType;
import com.example.E_Libarary.models.request.BookCreateRequest;
import com.example.E_Libarary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    BookService bookService;

@PostMapping("/save")
   public ResponseEntity saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
   return new ResponseEntity<>(bookService.saveBook(bookCreateRequest), HttpStatus.OK);
}

  @GetMapping("/search")
    public List<Book> searchBook(@RequestParam("filterType")BookFilterType bookFilterType,
                      @RequestParam("filterValue") String filterValue){
   return bookService.findBooksByFilter(bookFilterType,filterValue);
  }
}
