// ExerciseRepository.java
package com.sitpass.repository;

import com.sitpass.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // Pretraga rezervacija po ID-u objekta i vremenskom opsegu
    @Query("SELECT e FROM Exercise e WHERE e.facility.id = :facilityId AND e.startTime BETWEEN :startTime AND :endTime")
    List<Exercise> findByFacilityIdAndTimeRange(Long facilityId, LocalDateTime startTime, LocalDateTime endTime);

    // Provera da li je korisnik posetio objekat
    boolean existsByUserIdAndFacilityId(Long userId, Long facilityId);
}
