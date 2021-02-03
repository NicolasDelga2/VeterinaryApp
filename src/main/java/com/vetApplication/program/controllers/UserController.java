package com.vetApplication.program.controllers;


import com.vetApplication.program.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired private UserDetailsServiceImpl userService;

}
