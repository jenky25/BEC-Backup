package com.example.JWTSecure.service;

import com.example.JWTSecure.DTO.*;
import com.example.JWTSecure.domain.Classes;
import com.example.JWTSecure.domain.Course;
import com.example.JWTSecure.domain.Quiz;
import com.example.JWTSecure.domain.Room;

import java.util.List;

public interface AcademicAdminService {

    List<Quiz> getQuiz(Long levelId);
    ResponseStatus deleteQuiz(Long id);
    ResponseStatus editQuiz(Quiz quiz);
    ResponseStatus addQuiz(Quiz quiz);
    SearchResultDTO<RoomDTO> getRoom(RoomDTO roomDTO);
    List<Room> getRooms();
    SearchResultDTO<AcademicAdminDTO> getAllAcad(AcademicAdminDTO academicAdminDTO);
    ResponseStatus addAcad(AddAcademicAdminDTO addAcademicAdminDTO);
    AcademicAdminDTO viewProfile(AcademicAdminDTO academicAdminDTO);
    ResponseStatus editAcad(AddAcademicAdminDTO addAcademicAdminDTO);
    ResponseStatus deleteAcad(Long id);
    ResponseStatus addCourse(Course course);
    ResponseStatus editCourse(CourseDTO courseDTO);
    List<Course> getCourse();
    SearchResultDTO<CourseDTO> getCoursePaging(CourseDTO courseDTO);
    SearchResultDTO<QuizDTO> getQuizPaging(QuizDTO quizDTO);
    Course getCourseById(Long id);
    List<ClassDTO> getClassByCourseId(Long id);

}
