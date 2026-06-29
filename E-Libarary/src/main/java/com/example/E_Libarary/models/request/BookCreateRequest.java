package com.example.E_Libarary.models.request;


import com.example.E_Libarary.models.Author;
import com.example.E_Libarary.models.Book;
import com.example.E_Libarary.models.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookCreateRequest {

  @NotBlank
    private String title;
  @Positive
    private int cost;
  @NonNull
    private Genre genre;
  @NonNull
    private Author author;

  public Book toBook(){
      return Book.builder()
              .title(this.title)
              .cost(this.cost)
              .genre(this.genre)
              .author(this.author)
              .build();
  }
}
