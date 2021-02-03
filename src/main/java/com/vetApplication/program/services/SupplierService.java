package com.vetApplication.program.services;

import com.vetApplication.program.models.Supplier;
import com.vetApplication.program.repositories.SupplierRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Para debug
    private static final Log logger = LogFactory.getLog(SupplierService.class);

    public List<Supplier> getSuppliers(){
        try {
            logger.info("findAll Suppliers");
            return supplierRepository.findAll();
        }catch (Exception e){
            logger.info("Error");
            return null;
        }
    }

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(Integer id){
        return supplierRepository.findById(id);
    }

    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }
}
