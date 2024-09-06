// ReviewRepository.java
package com.sitpass.repository;

import com.sitpass.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByFacilityId(Long facilityId);
}
