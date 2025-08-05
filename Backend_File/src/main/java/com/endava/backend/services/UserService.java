package com.endava.backend.services;

import com.endava.backend.dtos.UserDTO;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    
}
