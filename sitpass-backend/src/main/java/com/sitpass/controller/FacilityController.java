// FacilityController.java
package com.sitpass.controller;

import com.sitpass.model.Facility;
import com.sitpass.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    // Dodavanje novog objekta (samo admin)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Facility> createFacility(@RequestBody Facility facility) {
        return new ResponseEntity<>(facilityService.createFacility(facility), HttpStatus.CREATED);
    }

    // Ažuriranje objekta (samo menadžer ili admin)
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Long id, @RequestBody Facility facility) {
        return new ResponseEntity<>(facilityService.updateFacility(id, facility), HttpStatus.OK);
    }

    // Brisanje objekta (samo admin)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Dobijanje svih objekata
    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return new ResponseEntity<>(facilityService.getAllFacilities(), HttpStatus.OK);
    }
}
