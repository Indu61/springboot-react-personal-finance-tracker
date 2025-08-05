package com.endava.backend.mapper;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.endava.backend.dtos.SavingGoalDTO;
import com.endava.backend.entities.SavingGoal;

@Component
public class SavingGoalMapper {
    
    public SavingGoal dtoToEntity(SavingGoalDTO dto) {
        if(dto == null) return null;

        return SavingGoal.builder().goalId(dto.getGoalId()).user(dto.getUser())
        .goalName(dto.getGoalName()).targetAmount(dto.getTargetAmount())
        .savingAmount(dto.getSavingAmount()).deadLine(dto.getDeadLine())
        .createdAt(dto.getCreatedAt()).build();
    }

    public SavingGoalDTO entityToDto(SavingGoal entity) {
        if(entity == null ) return null;

        return SavingGoalDTO.builder().goalId(entity.getGoalId()).user(entity.getUser())
        .goalName(entity.getGoalName()).targetAmount(entity.getTargetAmount())
        .savingAmount(entity.getSavingAmount()).deadLine(entity.getDeadLine())
        .createdAt(entity.getCreatedAt()).build();
    }

    public List<SavingGoalDTO> entityListToDtoList(List<SavingGoal> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDto).toList();
    }
}
