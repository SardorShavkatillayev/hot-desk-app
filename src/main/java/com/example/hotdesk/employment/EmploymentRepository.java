package com.example.hotdesk.employment;

import com.example.hotdesk.employment.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Integer> {
    @Query("SELECT e FROM Employment e WHERE e.room.id = :roomId AND " +
            "(e.started < :endDate AND e.ended > :startDate)")
    List<Employment> findConflictingEmployments(@Param("roomId") Integer roomId,
                                                @Param("startDate") LocalDate startDate,
                                                @Param("endDate") LocalDate endDate);


}
