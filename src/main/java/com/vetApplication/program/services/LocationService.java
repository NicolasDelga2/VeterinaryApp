package com.vetApplication.program.services;

import com.vetApplication.program.models.Location;
import com.vetApplication.program.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired private LocationRepository locationRepository;

    public void save(Location location){
        locationRepository.save(location);
    }

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    public void delete(int id){
        locationRepository.deleteById(id);
    }
}
