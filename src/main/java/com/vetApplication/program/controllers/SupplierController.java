package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Supplier;
import com.vetApplication.program.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getSuppliers")
    public List<Supplier> getSuppliers(){
        return supplierService.getSuppliers();
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody Supplier supplier){
        supplierService.save(supplier);
    }

    @PutMapping("/update")
    public void update(@RequestBody Supplier supplier){
        supplierService.save(supplier);
    }

    @GetMapping("/findById/{id}")
    public Optional<Supplier> findById(@PathVariable("id") Integer id){
        return supplierService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        supplierService.delete(id);
    }

}
