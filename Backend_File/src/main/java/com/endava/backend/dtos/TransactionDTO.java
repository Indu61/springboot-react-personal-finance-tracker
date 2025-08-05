package com.endava.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.endava.backend.entities.Account;
import com.endava.backend.entities.Category;
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
public class TransactionDTO {
    
    private Long transactionId;
    private User user;
    private Account account;
    private BigDecimal transactionAmount;
    private Category category;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
