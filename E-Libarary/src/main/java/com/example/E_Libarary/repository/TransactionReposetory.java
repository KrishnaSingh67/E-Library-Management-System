package com.example.E_Libarary.repository;

import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.Transaction;
import com.example.E_Libarary.models.enums.TransationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TransactionReposetory extends JpaRepository<Transaction,Integer> {
    Transaction findTopByBookAndStudentAndTransationTypeOrderByIdDesc(Book book, Student student, TransationType transationType);

}
