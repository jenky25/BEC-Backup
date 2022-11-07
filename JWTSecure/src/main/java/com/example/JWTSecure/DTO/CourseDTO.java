package com.example.JWTSecure.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class CourseDTO implements Serializable {

    private Long id;
    private Long levelId;
    private String course_name;
    private String level;
    private String createdAt;
    private String updatedAt;
    private Integer numberSlot;
    private int page;
    private int pageSize;
    private String key_search;
}
