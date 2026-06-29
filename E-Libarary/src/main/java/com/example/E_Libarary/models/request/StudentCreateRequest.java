package com.example.E_Libarary.models.request;


import com.example.E_Libarary.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentCreateRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;

    @NotBlank
    private  Long phoneNo;

    private String address;

    public Student toStudent(){
        return Student.builder()
                .name(name).email(email).address(address).phone_no(phoneNo)
                .build();
    }

}
