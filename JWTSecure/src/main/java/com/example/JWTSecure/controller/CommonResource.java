package com.example.JWTSecure.controller;

import com.example.JWTSecure.domain.Course;
import com.example.JWTSecure.domain.Slot;
import com.example.JWTSecure.service.AcademicAdminService;
import com.example.JWTSecure.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common")
@RequiredArgsConstructor
public class CommonResource {

    private final AcademicAdminService academicAdminService;

    @GetMapping("/get_course")
    public ResponseEntity<List<Course>> getSlot() {
        return ResponseEntity.ok().body(academicAdminService.getCourse());
    }

}
