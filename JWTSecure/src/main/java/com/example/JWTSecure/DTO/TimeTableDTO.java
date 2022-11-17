package com.example.JWTSecure.DTO;

import com.nimbusds.jose.util.Pair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TimeTableDTO implements Serializable{
    private String class_name;
    private String start_date;
    private String end_date;
    private String first_of_week;
    private String second_of_week;
    private String room_name;
    private String course_name;
    private Integer number_slot;
    private String from_time;
    private String to_time;
    private ArrayList<Map<LocalDate, String>> for_time;


}
