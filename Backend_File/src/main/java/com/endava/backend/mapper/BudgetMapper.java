package com.endava.backend.mapper;

import org.springframework.stereotype.Component;

import com.endava.backend.dtos.BudgetDTO;
import com.endava.backend.entities.Budget;
import java.util.List;
import java.util.Collections;

@Component
public class BudgetMapper {
    
    public Budget dtoToEntity(BudgetDTO dto) {
        if(dto == null) return null;

        return Budget.builder().budgetId(dto.getBudgetId()).user(dto.getUser()).budgetName(dto.getBudgetName())
        .amount(dto.getAmount()).month(dto.getMonth()).createdAt(dto.getCreatedAt())
        .updatedAt(dto.getUpdatedAt()).build();
    }

    public BudgetDTO entityToDTO(Budget entity) {
        if(entity == null) return null;

        return BudgetDTO.builder().budgetId(entity.getBudgetId()).user(entity.getUser())
        .budgetName(entity.getBudgetName()).amount(entity.getAmount()).month(entity.getMonth())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }

    public List<BudgetDTO> entityListToDtoList(List<Budget> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDTO).toList();
    }
    
}