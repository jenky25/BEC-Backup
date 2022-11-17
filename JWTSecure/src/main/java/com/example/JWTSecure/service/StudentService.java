package com.example.JWTSecure.service;
import com.example.JWTSecure.DTO.*;
import com.example.JWTSecure.domain.Curriculum;
import com.example.JWTSecure.domain.StudentInClass;

import java.util.List;


public interface StudentService {

    StudentDTO getStudent(StudentDTO studentDTO);
    SearchResultDTO<StudentDTO> getAllStudent(StudentDTO studentDTO);
    SearchResultDTO<StudentDTO> getStudentPending(StudentDTO studentDTO);
    ResponseStatus addStudent(AddStudentDTO addStudentDTO);
    ResponseStatus editStudent(AddStudentDTO addStudentDTO);
    List<StudentDTO> getListStudentByIdClass(Long id);
    List<StudentDTO>  detailStudentClass(Long id);
    ResponseStatus updatePending(Long id);
    ResponseStatus deletePending(Long id);
    ResponseStatus addCurriculum(Curriculum curriculum);
    ResponseStatus registerCourse(StudentInClass studentInClass);
}
