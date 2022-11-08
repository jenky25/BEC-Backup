package com.example.JWTSecure.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAcademicAdminDTO {

    private Long id;
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
