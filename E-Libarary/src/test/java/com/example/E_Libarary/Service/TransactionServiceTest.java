package com.example.E_Libarary.Service;

import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.Transaction;
import com.example.E_Libarary.models.enums.AccountStatus;
import com.example.E_Libarary.models.enums.Genre;
import com.example.E_Libarary.models.enums.TransationType;
import com.example.E_Libarary.repository.TransactionReposetory;
import com.example.E_Libarary.service.BookService;
import com.example.E_Libarary.service.StudentService;
import com.example.E_Libarary.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.processing.Exclude;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    StudentService studentService;
     @Mock
    BookService bookService;
@Mock
    TransactionReposetory transactionReposetory;


   @InjectMocks
    TransactionService transactionService;

//@BeforeEach
//    public void print(){
//    log.debug("in befor  ecach ");
//}

@Test
@DisplayName("Test1: prefer Issue Trensaction")
@Order(1)
public void transact_test(){

    int bookId=1;
    int studentId=1;
    int transactionid=1;
    String externalTransactionId= UUID.randomUUID().toString();

    Optional<Student> studentOptional= Optional.ofNullable(Student.builder()
                    .id(studentId).name("krishna").email("krishna@gmail.com")
                    .phone_no(9005767509L).address("India").accountStatus(AccountStatus.ACTIVE)
            .build());
    Optional<Book> bookOptional=Optional.ofNullable(Book.builder()
            .id(bookId).title("intro of jba").genre(Genre.FICTION)
            .cost(500).build());
    Transaction transaction=Transaction.builder()
            .id(transactionid).externalId(externalTransactionId)
            .transationType(TransationType.ISSUE)
            .student(studentOptional.get()).book(bookOptional.get()).build();

 when(studentService.getStudent(anyInt())).thenReturn(studentOptional);
 when(bookService.getBook(anyInt())).thenReturn(bookOptional);
when(transactionReposetory.save(any())).thenReturn(transaction);

   String teansactionId= transactionService.transact(studentId,bookId, TransationType.ISSUE.name());

   // Assertions.assertEquals(teansactionId,externalTransactionId);
    Assertions.assertFalse(teansactionId.isBlank());

  // verify no. of times particular meathodd is called
    Mockito.verify(studentService,times(1)).getStudent(anyInt());

}

}
