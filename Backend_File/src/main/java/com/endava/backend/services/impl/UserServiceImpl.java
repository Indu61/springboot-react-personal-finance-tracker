package com.endava.backend.services.impl;
import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.endava.backend.constant.LiteralConstant;
import com.endava.backend.dtos.UserDTO;
import com.endava.backend.entities.User;
import com.endava.backend.exception.ResourceNotSavedException;
import com.endava.backend.exception.ResourceNotFoundException;
import com.endava.backend.mapper.UserMapper;
import com.endava.backend.repository.UserRepo;
import com.endava.backend.services.UserService;
import com.endava.backend.utils.PasswordUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    /**
	 * Registers a new user ensuring that the email or
	 * license number doesn't already exist.
	 * 
	 * @param userDto DTO representing the user to be registered.
	 * @return A UserDTO representing the successfully registered user.
	 */

     @Override
     public UserDTO registerUser(UserDTO userDTO) {

        // Check if the user already exists by email
        userRepo.findByEmail(userDTO.getEmail()).ifPresent(userDetail -> {
            throw new ResourceNotSavedException("User with email " + userDTO.getEmail() + " already exists.");
        });

        // convert DTO to entity and set timestamp
       User user = userMapper.dtoToEntity(userDTO);
       user.setCreatedAt(LocalDateTime.now());


       // Set user as logged out intitially and Save the entity to DB
       user.setLoggedIn(false); 
       user.setPasswordHash(PasswordUtil.hashPassword(user.getPasswordHash()));
        user = Optional.ofNullable(userRepo.save(user))
        .orElseThrow(() -> new ResourceNotSavedException("User could not be saved."));

       // remove password hash before returning DTO
        user.setPasswordHash(null);
        return userMapper.entityToDto(user);
     }

     /**
	 * Retrieves a user by their ID.
	 * 
	 * @param userId The ID of the user to retrieve.
	 * @return A UserDTO representing the user with the given ID.
	 */
	@Override
	public UserDTO getUserById(Long userId) {
		return userRepo.findById(userId).map(userMapper::entityToDto)
				.orElseThrow(() -> new ResourceNotFoundException(LiteralConstant.USER_ID_ERROR_STRING + userId));
	}
    

    
}
