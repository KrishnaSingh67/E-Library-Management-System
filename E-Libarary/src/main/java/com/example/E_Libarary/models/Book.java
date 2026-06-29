package com.example.E_Libarary.models;

import com.example.E_Libarary.models.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"student"})
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     private String title;
     private int cost;

//     @Enumerated(value = EnumType.STRING)
     private Genre genre;

     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn
     @JsonIgnoreProperties({"booklist"})
     private Author author;

     @ManyToOne
     @JoinColumn            // it will give the forgen key
     private Student student;

    @OneToMany(mappedBy = "book")
     private List<Transaction> transactionList;

     @CreationTimestamp
     private Date createdOn;
     @UpdateTimestamp
      private Date updatedOn;
}
