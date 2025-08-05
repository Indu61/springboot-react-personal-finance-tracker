package com.endava.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.endava.backend.response.ApiResponse;
import com.endava.backend.services.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    /**
	 * Handles the login procedure for users.
	 * 
	 * @param email User's email for authentication.
	 * @param password User's password for authentication.
	 * @return ResponseEntity containing ApiResponse.
	 */

     @PostMapping("/login")
     public ResponseEntity<ApiResponse<Object>> login(@RequestParam String email, @RequestParam String password){
        Object loginResponse = authService.login(email, password);
        return new ResponseEntity<>(new ApiResponse<>(loginResponse), HttpStatus.OK);
     }

     /**
	 * Handles the logout procedure for a user.
	 * 
	 * @param email Email of the user who wishes to log out.
	 * @return ApiResponse with a message confirming logout.
	 */

     @PostMapping("/logout")
     public ResponseEntity<ApiResponse<String>> logout(@RequestParam String email) {
      authService.logout(email);
      return new ResponseEntity<>(new ApiResponse<>("Logout successful"), HttpStatus.OK);
     }

     @PostMapping("/resetPassword")
     public ResponseEntity<ApiResponse<String>> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
      authService.resetPassword(email, newPassword);
      return new ResponseEntity<>(new ApiResponse<>("Password reset successfully"), HttpStatus.OK);
     }

}
