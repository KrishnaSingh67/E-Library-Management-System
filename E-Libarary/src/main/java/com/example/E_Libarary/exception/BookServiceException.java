package com.example.E_Libarary.exception;

public class BookServiceException extends RuntimeException{

    public BookServiceException(String masage){
        super(masage);
    }
}
