package com.example.JWTSecure.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TimeTableDTO implements Serializable{
    private String class_name;
    private String room_name;
    private String teacher;
    private String start_time;
    private String end_time;

}
