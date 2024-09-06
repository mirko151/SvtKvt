package com.sitpass.service;

import com.sitpass.model.Exercise;
import com.sitpass.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> findExercisesByFacility(Long facilityId) {
        return exerciseRepository.findByFacilityId(facilityId);
    }

    public boolean isTimeSlotAvailable(Long facilityId, LocalDateTime startTime, LocalDateTime endTime) {
        // Logika za proveru dostupnosti termina
        List<Exercise> existingReservations = exerciseRepository.findByFacilityIdAndTimeRange(facilityId, startTime, endTime);
        return existingReservations.isEmpty();
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }
}
