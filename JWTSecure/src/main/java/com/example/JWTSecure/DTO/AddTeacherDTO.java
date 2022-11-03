package com.example.JWTSecure.DTO;

import com.example.JWTSecure.domain.Teacher;
import com.example.JWTSecure.domain.User;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class AddTeacherDTO {

    private Long id;
    private Long user_Id;
    private String user_name;
    private String full_name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private String message;
    private boolean state;
}
