package com.example.E_Libarary.controller;


import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.request.StudentCreateRequest;
import com.example.E_Libarary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        return new ResponseEntity<>(studentService.saveStudent(studentCreateRequest),HttpStatus.CREATED);
    }
}
