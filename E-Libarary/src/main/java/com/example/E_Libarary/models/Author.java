package com.example.E_Libarary.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"booklist"})
public class Author {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;

    @Column(nullable = false)
    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book>booklist;


    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

}
