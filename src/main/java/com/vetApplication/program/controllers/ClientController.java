package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Client;
import com.vetApplication.program.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/client")
public class ClientController {

    @Autowired private ClientService clientService;

    @PostMapping("/addNew") // localhost:8080/v1/client/addNew
    public void addNew(@RequestBody Client client) {
        clientService.save(client);
    }

}
