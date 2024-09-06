package com.sitpass.service;

import com.sitpass.model.Review;
import com.sitpass.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review leaveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByFacility(Long facilityId) {
        return reviewRepository.findByFacilityId(facilityId);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
