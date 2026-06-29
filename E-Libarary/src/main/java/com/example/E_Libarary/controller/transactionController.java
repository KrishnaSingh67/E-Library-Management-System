package com.example.E_Libarary.controller;

import com.example.E_Libarary.models.MyUser;
import com.example.E_Libarary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
public class transactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/{transationType}")
    public ResponseEntity transact(@RequestParam("bookId") int bookId,
                                   @PathVariable("transationType") String transationType){

        // seting the security context here
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser=(MyUser) authentication.getPrincipal();

        if (myUser.getStudent()==null){
            throw new RuntimeException("User is not a student");
        }
        return new ResponseEntity<>(transactionService.transact(myUser.getStudent().getId(), bookId,transationType), HttpStatus.CREATED);
    }
}
