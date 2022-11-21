package com.example.JWTSecure.controller;
import com.example.JWTSecure.DTO.*;
import com.example.JWTSecure.DTO.ResponseStatus;
import com.example.JWTSecure.domain.Classes;
import com.example.JWTSecure.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherResource {

    private final TeacherService teacherService;

    @PutMapping("/edit_profile")
    public ResponseEntity<ResponseStatus> editTeacher(@RequestBody AddTeacherDTO addTeacherDTO) {
        return ResponseEntity.ok().body(teacherService.editTeacher(addTeacherDTO));
    }

    @GetMapping("/view_profile")
    public ResponseEntity<TeacherDTO> getTeacher(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.ok().body(teacherService.viewProfile(teacherDTO));
    }

    @PostMapping("/get_class_teacher")
    public ResponseEntity<List<Classes>> getClassTeacher(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.ok().body(teacherService.getClasses(teacherDTO.getTeacher_Id()));
    }

    @PostMapping("/get_time_table_class")
    public ResponseEntity<TimeTableDTO> getTimetable(@RequestBody Classes classes) {
        return ResponseEntity.ok().body(teacherService.getTimetableByClasses(classes.getId()));
    }

}
