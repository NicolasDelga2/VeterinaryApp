package com.vetApplication.program.controllers;


import com.vetApplication.program.models.User;
import com.vetApplication.program.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("management/api/v1/user")
public class UserController {

    @Autowired private UserDetailsServiceImpl userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable int id){
        return userService.findById(id);
    }


}
