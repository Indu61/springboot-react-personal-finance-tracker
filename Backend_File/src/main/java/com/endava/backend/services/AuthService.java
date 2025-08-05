package com.endava.backend.services;


public interface AuthService {
    Object login(String email, String password);
    void logout(String email);
    boolean resetPassword(String email, String newPassword);
    // boolean sentOTP(String email);
}
