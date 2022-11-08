package com.example.JWTSecure.repo;

import com.example.JWTSecure.domain.Admin;
import com.example.JWTSecure.domain.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClassRepo extends JpaRepository<Classes, Long> {

    Classes findTopByOrderByIdDesc();
    void deleteByCourseId(Long id);
}
