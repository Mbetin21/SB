/**
 * This file defines the REST API controller for managing user-related requests.
 * It exposes endpoints to fetch user data.
 * 
 * Author: Mariam Betin <mbetine@udistrital.edu.co>
 */
package com.example.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.data_objects.UserData;
import com.example.backend.services.UserService;

/**
 * REST API controller for managing user-related requests.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     * @return List of users.
     */
    @GetMapping("/all")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
    }
}
