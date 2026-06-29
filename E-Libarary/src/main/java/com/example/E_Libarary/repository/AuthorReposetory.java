package com.example.E_Libarary.repository;

import com.example.E_Libarary.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorReposetory extends JpaRepository<Author,Integer> {

    Author findByEmail(String email);

}
