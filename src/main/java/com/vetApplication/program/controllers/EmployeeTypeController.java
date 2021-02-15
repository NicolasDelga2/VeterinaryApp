package com.vetApplication.program.controllers;

import com.vetApplication.program.models.EmployeeType;
import com.vetApplication.program.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employeeType")
public class EmployeeTypeController {

    @Autowired private EmployeeTypeService employeeTypeService;

    @PostMapping("/addNew")
    public void addNew(@RequestBody EmployeeType employeeType){
        employeeTypeService.save(employeeType);
    }

    @GetMapping("/getEmployeeTypes")
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeService.getEmployeeTypes();
    }

    @GetMapping(value = "/findById/{employeeTypeId}")
    public Optional<EmployeeType> findById(@PathVariable int employeeTypeId){
        return employeeTypeService.findById(employeeTypeId);
    }

    @DeleteMapping("/delete/{employeeTypeId}")
    public void delete(@PathVariable int employeeTypeId){
        employeeTypeService.delete(employeeTypeId);
    }

    @PutMapping("/update")
    public void update(@RequestBody EmployeeType employeeType){
        employeeTypeService.save(employeeType);
    }
}
