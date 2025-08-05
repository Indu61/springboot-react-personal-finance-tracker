package com.endava.backend.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.endava.backend.constant.LiteralConstant;
import com.endava.backend.exception.InvalidCredentialsException;
import com.endava.backend.exception.ResourceNotFoundException;
import com.endava.backend.mapper.UserMapper;
import com.endava.backend.repository.UserRepo;
import com.endava.backend.services.AuthService;
import com.endava.backend.utils.PasswordUtil;

import lombok.RequiredArgsConstructor;

import com.endava.backend.entities.User;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{
    
    private final UserRepo userRepo;
    private final UserMapper userMapper;

       
    public void checkValidString(String str, String errorMessage) {
        if(str == null || str.trim().isEmpty()) {
            throw new InvalidCredentialsException(errorMessage);
        }
    }

    public boolean validatePassword(User user, String password) {
        if (user == null || password == null || password.trim().isEmpty()) {
            throw new InvalidCredentialsException("User or password cannot be null or empty");
        }
        return user.getPasswordHash().equals(password) || PasswordUtil.checkPassword(password, user.getPasswordHash());
    }

     /**
     * Logs in the user by verifying the username and password. Throws
     * InvalidCredentialsException if the credentials are invalid.
     *
     * @param email the email of the user
     * @param password the password of the user
     * @return the user details in DTO format
     * @throws InvalidCredentialsException if the email or password is incorrect
     */

    @Override
    public Object login(String email, String password) {
        checkValidString(email, LiteralConstant.EMAIL_EMPTY_ERROR_STRING);
        checkValidString(password, "Password is required");

        User user = userRepo.findByEmail(email.trim())
        .orElseThrow(() -> new InvalidCredentialsException("Invalid email or Password"));

        Optional.of(validatePassword(user, password)).filter(valid -> valid)
        .orElseThrow(() -> new InvalidCredentialsException("Invalid email or Password"));

        user.setLoggedIn(true);
        userRepo.save(user);
        return userMapper.entityToDto(user);
    }

    /**
     * Logs out the user by setting the LoggedIn status to false. Throws
     * InvalidCredentialsException if the username doesn't exist.
     *`
     * @param username the username of the user to log out
     * @throws InvalidCredentialsException if the username is not found
     */

    @Override
    public void logout(String email) {
        checkValidString(email, LiteralConstant.EMAIL_EMPTY_ERROR_STRING);

        userRepo.findByEmail(email.trim()).ifPresentOrElse(user -> {
            user.setLoggedIn(false);
            userRepo.save(user);
        }, () -> {
            throw new InvalidCredentialsException("Invalid email");
        });

    }

    /**
     * Resets the password for the user with the specified email. Throws
     * ResourceNotFoundException if the user does not exist.
     *
     * @param email       the email of the user
     * @param newPassword  the new password to set
     * @return true if the password is reset successfully
     * @throws ResourceNotFoundException if the user is not found with the specified
     *                                   email
     */

    @Override
    public boolean resetPassword(String email, String newPassword) {
        checkValidString(email, LiteralConstant.EMAIL_EMPTY_ERROR_STRING);
        checkValidString(newPassword, "Password cannot be Empty");

        return userRepo.findByEmail(email.trim())
            .map(user -> {
                user.setPasswordHash(PasswordUtil.hashPassword(newPassword));
                userRepo.save(user);
                return true;
            })
            .orElseThrow(() -> new ResourceNotFoundException("User not found with email:" + email));
    }

    /**
     * Sends an OTP to the user with the specified username. Throws
     * ResourceNotFoundException if the user is not found.
     *
     * @param username the username of the user to send OTP
     * @return true if the OTP is sent successfully
     * @throws ResourceNotFoundException if the user is not found with the specified
     *                                   username
     */

    //  @Ovverride
    //  public boolean sentOTP(String email) {
    //     checkValidString(email, LiteralConstant.EMAIL_EMPTY_ERROR_STRING);

    //     return userRepo.findByEmail(email)
    //  }


}
