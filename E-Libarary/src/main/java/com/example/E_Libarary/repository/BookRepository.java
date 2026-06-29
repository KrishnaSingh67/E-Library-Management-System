package com.example.E_Libarary.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.awt.print.Book;
import  com.example.E_Libarary.models.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByTitle(String Title);

    List<Book> findByAuthor(String author);

    List<Book> findByid(int id);

    List<Book> findByCost(int Cost);

    List<Book> findByGenre(String Genre);

}
