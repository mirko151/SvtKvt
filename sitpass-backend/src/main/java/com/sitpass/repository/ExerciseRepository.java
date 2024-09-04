package com.sitpass.repository;

import com.sitpass.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByFacilityId(Long facilityId);
    List<Exercise> findByFacilityIdAndTimeRange(Long facilityId, LocalDateTime startTime, LocalDateTime endTime);
}
