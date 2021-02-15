package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Client;
import com.vetApplication.program.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired private ClientService clientService;

    @PostMapping("/addNew") // localhost:8080/v1/client/addNew
    public void addNew(@RequestBody Client client) {
        clientService.save(client);
    }

    @GetMapping("/getCLients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/findById/{clientId}")
    public Optional<Client> findById(@PathVariable int clientId){
        return clientService.findById(clientId);
    }

    @PutMapping("/update")
    public void update(@RequestBody Client client){
        clientService.save(client);
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable int clientId){
        clientService.delete(clientId);
    }
}
