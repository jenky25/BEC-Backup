package com.example.JWTSecure.repo;

import com.example.JWTSecure.domain.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassScheduleRepo extends JpaRepository<ClassSchedule, Long> {
}
