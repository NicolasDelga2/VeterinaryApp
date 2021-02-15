package com.vetApplication.program.services;

import com.vetApplication.program.models.EmployeeType;
import com.vetApplication.program.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    public void delete(int id){
        employeeTypeRepository.deleteById(id);
    }

    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }
}
