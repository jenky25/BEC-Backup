package com.example.JWTSecure.repo;

import com.example.JWTSecure.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByUserId(Long id);

    @Modifying
    @Query("UPDATE Student s SET s.isPaid = true WHERE s.id = ?1")
    int updatePending(Long id);
}