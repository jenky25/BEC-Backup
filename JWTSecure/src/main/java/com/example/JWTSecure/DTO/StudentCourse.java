package com.example.JWTSecure.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentCourse implements Serializable {
    private Long student_Id;
    private String course_name;

    public StudentCourse(Long student_Id, String course_name) {
        this.student_Id = student_Id;
        this.course_name = course_name;
    }
}