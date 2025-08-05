package com.endava.backend.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class LiteralConstant {
    
    public static final String USER_ID_ERROR_STRING = "User not found with ID: ";
    public static final String EMAIL_EMPTY_ERROR_STRING = "Email is required";
}
