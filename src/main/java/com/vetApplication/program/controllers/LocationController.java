package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Location;
import com.vetApplication.program.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {

    @Autowired private LocationService locationService;

    @GetMapping("/getLocations")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping("/findById/{locationId}")
    public Optional<Location> findById(@PathVariable int locationId) {
        return locationService.findById(locationId);
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody Location location) {
        locationService.save(location);
    }

    @PutMapping("/update")
    public void update(@RequestBody Location location) {
        locationService.save(location);
    }

    @DeleteMapping("/delete/{locationId}")
    public void delete(@PathVariable int locationId) {
        locationService.delete(locationId);
    }
}
