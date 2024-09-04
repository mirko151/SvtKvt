package com.sitpass.controller;

import com.sitpass.model.Exercise;
import com.sitpass.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        if (exerciseService.isTimeSlotAvailable(exercise.getFacility().getId(), exercise.getStartTime(), exercise.getEndTime())) {
            Exercise newExercise = exerciseService.createExercise(exercise);
            return new ResponseEntity<>(newExercise, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Termin nije dostupan
        }
    }

    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<List<Exercise>> getExercisesByFacility(@PathVariable Long facilityId) {
        List<Exercise> exercises = exerciseService.findExercisesByFacility(facilityId);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
