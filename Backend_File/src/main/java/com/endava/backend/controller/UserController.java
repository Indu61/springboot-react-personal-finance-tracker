package com.endava.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.endava.backend.dtos.UserDTO;
import com.endava.backend.services.UserService;
import com.endava.backend.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

      private final UserService userService;
    /**
     * Register a new user
     * 
     * @param UserDto the data transfer object containing user details.
     * @return ResponseEntity with ApiResponse containing the registered user or an error message.
     */

     @PostMapping("/register")
     public ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody UserDTO userDto) {
        UserDTO registeredUser = userService.registerUser(userDto);
        return new ResponseEntity<>(new ApiResponse<>(registeredUser), HttpStatus.CREATED);
     }

      /**
     * Retrieves a user by their ID.
     * 
     * @param userId The ID of the user to retrieve.
     * @return ResponseEntity with ApiResponse containing the user details or an error message.
     */

     @GetMapping("/getUserbyId")
     public ResponseEntity<ApiResponse<UserDTO>> getUSerById(@RequestParam Long UserId) {
         UserDTO userDTO = userService.getUserById(UserId);
         return new ResponseEntity<>(new ApiResponse<>(userDTO), HttpStatus.OK);
     }
     


    
}
