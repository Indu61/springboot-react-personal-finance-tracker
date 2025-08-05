package com.endava.backend.dtos;

import java.math.BigDecimal;
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
public class BudgetDTO {

    private Long budgetId;
    private User user;
    private String budgetName;
    private BigDecimal amount;
    private String month;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
