package com.example.E_Libarary.service;


import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.request.StudentCreateRequest;
import com.example.E_Libarary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(StudentCreateRequest studentCreateRequest) {
        Student student=studentCreateRequest.toStudent();
    return studentRepository.save(student);
    }

    public Optional<Student> getStudent(int studentId) {
        return studentRepository.findById(studentId);
    }
}
