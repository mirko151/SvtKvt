package com.sitpass.repository;

import com.sitpass.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findByCityAndDisciplinesAndRating(String city, String discipline, int minRating);
}
