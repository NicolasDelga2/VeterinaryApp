package com.vetApplication.program.controllers;


import com.vetApplication.program.models.User;
import com.vetApplication.program.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("management/api/v1/user")
public class UserController {

    @Autowired private UserService userService;

    // hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission) hasAnyAuthority('permission)

    @GetMapping("/getUsers")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/addNew")
    @PreAuthorize("hasAuthority('empleado:write')")
    public void addNew(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('empleado:write')")
    public void update(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('empleado:write')")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable int id){
        return userService.findById(id);
    }


}
