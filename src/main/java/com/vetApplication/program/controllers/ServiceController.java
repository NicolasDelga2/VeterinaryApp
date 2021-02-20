package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Service;
import com.vetApplication.program.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/service")
public class ServiceController {

    @Autowired private ServiceService serviceService;

    @GetMapping("/getServices")
    public List<Service> getServiceList(){
        return serviceService.services();
    }

    @GetMapping("/findById/{id}")
    public Optional<Service> getService(@PathVariable int id){
        Service findService = (Service) getServiceList().stream().filter(service -> service.getId() == id);
        if(findService != null) {
            return serviceService.findById(id);
        }
        return null;
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody Service service){
        if(service != null){
            serviceService.save(service);
        }
    }

    @PutMapping("/update")
    public void update(@RequestBody Service service) throws Exception {
        if(getServiceList().contains(service)){
            serviceService.save(service);
        }else{
            throw new Exception("El servicio no existe");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        Service service = (Service) getServiceList()
                    .stream()
                    .filter(service1 -> service1.getId() == id);
        if(getServiceList().contains(service)){
            serviceService.delete(id);
        }else{
            throw new Exception("El servicio no existe");
        }
    }

}
