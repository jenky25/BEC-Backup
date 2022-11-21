package com.example.JWTSecure.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SearchTimeTable implements Serializable{
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
    private Integer slot_id;

    public SearchTimeTable(String class_name, String start_date, String end_date, String first_of_week, String second_of_week, String room_name, String course_name, Integer number_slot, String from_time, String to_time, Integer slot_id) {
        this.class_name = class_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.first_of_week = first_of_week;
        this.second_of_week = second_of_week;
        this.room_name = room_name;
        this.course_name = course_name;
        this.number_slot = number_slot;
        this.from_time = from_time;
        this.to_time = to_time;
        this.slot_id = slot_id;
    }

}
