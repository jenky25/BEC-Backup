package com.example.JWTSecure.service;

import com.example.JWTSecure.DTO.*;
import com.example.JWTSecure.domain.Course;
import com.example.JWTSecure.domain.Quiz;

import java.util.List;

public interface AcademicAdminService {

    List<Quiz> getQuiz(Long levelId);
    ResponseStatus deleteQuiz(Long id);
    ResponseStatus editQuiz(Quiz quiz);
    ResponseStatus addQuiz(Quiz quiz);
    SearchResultDTO<RoomDTO> getRoom(RoomDTO roomDTO);
    SearchResultDTO<AcademicAdminDTO> getAllAcad(AcademicAdminDTO academicAdminDTO);
    ResponseStatus addAcad(AddAcademicAdminDTO addAcademicAdminDTO);
    AcademicAdminDTO viewProfile(AcademicAdminDTO academicAdminDTO);
    ResponseStatus editAcad(AddAcademicAdminDTO addAcademicAdminDTO);
    ResponseStatus deleteAcad(Long id);
    ResponseStatus addCourse(Course course);
    ResponseStatus deleteCourse(Long id);
    ResponseStatus editCourse(Course course);
    List<Course> getCourse();
}
