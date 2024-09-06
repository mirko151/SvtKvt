// FacilityService.java
package com.sitpass.service;

import com.sitpass.model.Facility;
import com.sitpass.repository.FacilityRepository;
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

    public Facility updateFacility(Long id, Facility updatedFacility) {
        Facility facility = facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
        facility.setName(updatedFacility.getName());
        facility.setCity(updatedFacility.getCity());
        facility.setAddress(updatedFacility.getAddress());
        facility.setDisciplines(updatedFacility.getDisciplines());
        facility.setWorkingHours(updatedFacility.getWorkingHours());
        return facilityRepository.save(facility);
    }

    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
