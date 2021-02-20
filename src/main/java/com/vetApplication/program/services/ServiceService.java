package com.vetApplication.program.services;

import com.vetApplication.program.models.Service;
import com.vetApplication.program.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> services(){
        return serviceRepository.findAll();
    }

    public Optional<Service> findById(int id){
        return serviceRepository.findById(id);
    }

    public void save(Service service){
        serviceRepository.save(service);
    }

    public void delete(int id){
        serviceRepository.deleteById(id);
    }




}
