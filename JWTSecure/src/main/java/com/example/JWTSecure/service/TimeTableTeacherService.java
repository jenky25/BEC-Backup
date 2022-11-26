package com.example.JWTSecure.service;

import com.example.JWTSecure.DTO.TimeTableTeacherDTO;

import java.util.List;
import java.util.Map;

public interface TimeTableTeacherService {

    List<TimeTableTeacherDTO> getTimeTableOfTeacher(TimeTableTeacherDTO timeTableTeacherDTO);
    Map<String, String> getEveryWeek();
}
