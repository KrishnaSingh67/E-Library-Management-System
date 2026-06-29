package com.example.E_Libarary.service;

import com.example.E_Libarary.exception.BookServiceException;
import com.example.E_Libarary.exception.TranctionServiceException;
import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.Transaction;
import com.example.E_Libarary.models.enums.TransationType;
import com.example.E_Libarary.repository.TransactionReposetory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TransactionService {

    @Autowired
    StudentService studentService;
    @Autowired
    BookService bookService;
    @Autowired
    TransactionReposetory transactionReposetory;

    // Two types of transaction which are supported:
    //    1) Issue:
    //        - Check if a student is valid
    //        - Check if a book is valid
    //        - Check if a book is available
    //        - Make the book to student transaction
    //        - Make the book unavailable for others
    //    2) Return:
    //        - Check if a student is valid
    //        - Check if a book is valid
    //        - Check if the book is issued to the same student
    //        - Make the transaction
    //        - Make the book available for others

    public String transact(int studentId, int bookId, String transationType) {
        Optional<Student> student= studentService.getStudent(studentId);
//  validate student
        if (student.isEmpty()) {
            throw new TranctionServiceException("Student with this id are not present ");
        }
        Optional<Book> bookById = bookService.getBook(bookId);
//        validate book
        if (bookById.isEmpty()) {
            throw new BookServiceException("book are not valid");
        }

        switch (transationType)
        {
            case "ISSUE":
                    return issueBookTransaction(student,bookById);
            case "RETURN":
                return returnBookTransaction(student,bookById);
            default:
                throw new TranctionServiceException("transcation is not supported");
        }
    }

    private String issueBookTransaction(Optional<Student> student, Optional<Book> bookById) {
        // check for the avability of the book
        if (bookById.get().getStudent() != null) {
            throw new TranctionServiceException("Book is not avalable");
        }
        //Make the book to student transaction
        Transaction transaction = Transaction.builder()
                .externalId(UUID.randomUUID().toString())
                .book(bookById.get())
                .transationType(TransationType.ISSUE)
                .payment((double) bookById.get().getCost())
                .student(student.get())
                .build();

        transactionReposetory.save(transaction);
        // Make the book unavaliable for others
        bookById.get().setStudent(student.get());
        bookService.save(bookById.get());


        return transaction.getExternalId();
    }



    private String returnBookTransaction(Optional<Student> student, Optional<Book> bookById) {

        // Check if the book is already issued
        if (bookById.get().getStudent() == null) {
            throw new TranctionServiceException("Book is not issued to any student");
        }
        // Check if a book is issued to the same student
        if (bookById.get().getStudent().getId() != student.get().getId()) {
            throw new TranctionServiceException("book is issued to the different student ");
        }

        Transaction issueTransaction = transactionReposetory.findTopByBookAndStudentAndTransationTypeOrderByIdDesc(
                bookById.get(), student.get(), TransationType.ISSUE);

//calculate fine and make thwe book avaliable for the others
        Transaction transaction = Transaction.builder()
                .externalId(UUID.randomUUID().toString())
                .transationType(TransationType.RETURN)
                .payment((double) (bookById.get().getCost() - calculateFine(issueTransaction)))
                .book(bookById.get())
                .student(student.get())
                .build();
        transactionReposetory.save(transaction);

        // make the book abvabliable for others
        bookById.get().setStudent(null);
        bookService.save(bookById.get());
        return transaction.getExternalId();
    }

    private long calculateFine(Transaction issueTransaction) {
        long bookIssueTime = issueTransaction.getCreatedOn().getTime();
        long bookReturnTime = System.currentTimeMillis();

        long diffInMillis = bookReturnTime - bookIssueTime;
        long dayPassed = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        if (dayPassed > 15) {
            return (dayPassed - 15) * 10L;
        }
        return 0;
    }


}
