package com.example.E_Libarary.repository;

import com.example.E_Libarary.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Integer> {
    MyUser findByUsername(String username);
}
