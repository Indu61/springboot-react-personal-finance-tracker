package com.endava.backend.dtos;

import lombok.AccessLevel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.endava.backend.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AccountDTO {
    
    private Long accountId;
    private User user;
    private String name;
    private String accountType;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
