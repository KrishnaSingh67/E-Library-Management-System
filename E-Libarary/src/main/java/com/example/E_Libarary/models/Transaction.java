package com.example.E_Libarary.models;


import com.example.E_Libarary.models.enums.TransationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"book,student"})
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "transation_type")
    private TransationType transationType;

    private Double payment;

@ManyToOne
private Book book;

@ManyToOne
    private Student student;

    @CreationTimestamp
    private Date createdOn;

}
