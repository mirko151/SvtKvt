package com.sitpass.service;

import com.example.sitpass.model.Facility;
import com.example.sitpass.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    public Facility createFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
    }

    public Facility updateFacility(Long id, Facility facilityDetails) {
        Facility facility = facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
        facility.setName(facilityDetails.getName());
        facility.setCity(facilityDetails.getCity());
        facility.setAddress(facilityDetails.getAddress());
        facility.setDescription(facilityDetails.getDescription());
        facility.setWorkingHours(facilityDetails.getWorkingHours());
        facility.setDisciplines(facilityDetails.getDisciplines());
        return facilityRepository.save(facility);
    }

    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    public List<Facility> searchFacilities(String city, String discipline, int minRating) {
        // Logika za pretragu objekata
        return facilityRepository.findByCityAndDisciplinesAndRating(city, discipline, minRating);
    }
}
