package com.example.JWTSecure.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO implements Serializable {
    private Long student_Id;
    private Long user_Id;
    private Long role_Id;
    private Long class_Id;
    private String class_name;
    private String user_name;
    private String full_name;
    private String course_name;
    private List<String> courses;
    private List<String> classes;
    private Boolean isPaid;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private String start_date;
    private LocalDateTime from_date;
    private LocalDateTime to_date;
    private String key_search;
    private int page;
    private int pageSize;
//    private int resultData;
}