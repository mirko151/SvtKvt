// ReviewController.java
package com.sitpass.controller;

import com.sitpass.model.Review;
import com.sitpass.model.User;
import com.sitpass.service.ReviewService;
import com.sitpass.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ExerciseService exerciseService;

    // Kreiranje recenzije
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review, @RequestParam Long userId, @RequestParam Long facilityId) {
        if (exerciseService.userHasVisitedFacility(userId, facilityId)) {
            Review newReview = reviewService.createReview(review);
            return new ResponseEntity<>(newReview, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // Korisnik nije posetio objekat
        }
    }

    // Dobijanje svih recenzija za određeni objekat
    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<List<Review>> getReviewsByFacility(@PathVariable Long facilityId) {
        return new ResponseEntity<>(reviewService.getReviewsByFacility(facilityId), HttpStatus.OK);
    }
}
