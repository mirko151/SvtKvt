package com.sitpass.controller;

import com.sitpass.model.Facility;
import com.sitpass.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping("/{city}")
    public List<Facility> getFacilitiesByCity(@PathVariable String city) {
        return facilityRepository.findByCity(city);
    }

    @PostMapping("/add")
    public Facility addFacility(@RequestBody Facility facility) {
        return facilityRepository.save(facility);
    }
}
