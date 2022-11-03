package com.example.JWTSecure.repo;

import com.example.JWTSecure.domain.ClassSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSlotRepo extends JpaRepository<ClassSlot, Long> {

    List<ClassSlot> findBySlotIdAndFirstOfWeekAndSecondOfWeek(Long slotId, Integer firstOfWeek, Integer secondOfWeek);
    ClassSlot findBySlotId(Long slotId);
    ClassSlot findByFirstOfWeek(Integer firstOfWeek);
    ClassSlot findBySecondOfWeek(Integer secondOfWeek);
}
