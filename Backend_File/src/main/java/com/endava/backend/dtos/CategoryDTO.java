package com.endava.backend.dtos;

import java.security.Timestamp;

import com.endava.backend.entities.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CategoryDTO {
    
    private Long categoryId;
    private User user;
    private String categoryName;
    private String categoryType;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
