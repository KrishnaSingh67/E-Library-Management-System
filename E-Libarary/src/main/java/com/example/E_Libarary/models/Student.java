package com.example.E_Libarary.models;

import com.example.E_Libarary.models.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)         //it will remove the null properties from the response json
@ToString(exclude = {"bookList"})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true, nullable = false)
    private Long phone_no;

    private String address;

    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "student")
    public List<Book> bookList;

    @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
    private List<Transaction> transactionList;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties({"student","admin"})
    private MyUser myUser;       /////

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
