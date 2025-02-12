package com.example.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.data_objects.UserData;
import com.example.backend.repositories.UserRepository;

/**
 * Service that handles user logic.
 */
@Service
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public List<UserData> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
