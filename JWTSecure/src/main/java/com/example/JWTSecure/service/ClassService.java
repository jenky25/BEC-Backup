package com.example.JWTSecure.service;

import com.example.JWTSecure.DTO.ClassDTO;
import com.example.JWTSecure.DTO.ResponseStatus;
import com.example.JWTSecure.DTO.SearchResultDTO;

import java.text.ParseException;

public interface ClassService {
    SearchResultDTO<ClassDTO> getAllClass(ClassDTO classDTO);
    ResponseStatus addClass(ClassDTO classDTO) throws ParseException;
    ResponseStatus disableClass(Long id);
}
