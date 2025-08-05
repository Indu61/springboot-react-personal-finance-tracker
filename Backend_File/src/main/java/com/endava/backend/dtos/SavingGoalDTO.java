package com.endava.backend.dtos;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDate;

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
public class SavingGoalDTO {
    
    private Long goalId;
    private User user;
    private String goalName;
    private BigDecimal targetAmount;
    private BigDecimal savingAmount;
    private LocalDate deadLine;
    private Timestamp createdAt;
}
