package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Employee;
import com.vetApplication.program.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    @PostMapping("/addNew")
    public void addNew(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/findById/{employeeId}")
    public Optional<Employee> findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void delete(@PathVariable int employeeId){
        employeeService.delete(employeeId);
    }

}
