package com.example.E_Libarary.service;

import com.example.E_Libarary.models.Author;
import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.enums.BookFilterType;
import com.example.E_Libarary.models.request.BookCreateRequest;
import com.example.E_Libarary.repository.AuthorReposetory;
import com.example.E_Libarary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorReposetory authorReposetory;

    public Book saveBook(BookCreateRequest bookCreateRequest) {
    Book book=  bookCreateRequest.toBook();
    Author author=book.getAuthor();

    //logic to check if author already exits
        Author authorFromDb=authorReposetory.findByEmail(author.getEmail());
         if (authorFromDb==null){
             authorFromDb=authorReposetory.save(author);
         }
         //setting the object recived from the databsese as it contain id
        book.setAuthor(authorFromDb);
        return bookRepository.save(book);

    }

    public List<Book> findBooksByFilter(BookFilterType bookFilterType, String filterValue) {

        switch (bookFilterType){
            case TITLE -> {
                return bookRepository.findByTitle(filterValue);
            }
            case AURTHOR_NAME -> {
                return bookRepository.findByAuthor(filterValue);
            }
            case BookID -> {
                return bookRepository.findByid(Integer.parseInt(filterValue));
            }
            case COST -> {
                return bookRepository.findByCost(Integer.parseInt(filterValue));
            }
            case GENRE -> {
                return bookRepository.findByGenre(filterValue);
            }
        }
        return null;
    }

    public Optional<Book> getBook(int bookId) {
        return bookRepository.findById(bookId);
    }

    public Book save(Book book) {
    return bookRepository.save(book);
    }


}
