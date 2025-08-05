package com.endava.backend.mapper;

import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

import com.endava.backend.dtos.TransactionDTO;
import com.endava.backend.entities.Transaction;

@Component
public class TransactionMapper {

    public Transaction dtoToEntity(TransactionDTO dto) {
        if(dto == null) return null;

        return Transaction.builder().transactionId(dto.getTransactionId())
        .user(dto.getUser()).account(dto.getAccount()).transactionAmount(dto.getTransactionAmount())
        .category(dto.getCategory()).description(dto.getDescription())
        .createdAt(dto.getCreatedAt()).updatedAt(dto.getUpdatedAt()).build();
    }
    
    public TransactionDTO entityToDto(Transaction entity) {
        if(entity == null) return null;

        return TransactionDTO.builder().transactionId(entity.getTransactionId())
        .user(entity.getUser()).account(entity.getAccount()).transactionAmount(entity.getTransactionAmount())
        .category(entity.getCategory()).description(entity.getDescription())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }

    public List<TransactionDTO> entityListToDtoList(List<Transaction> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDto).toList();
    }
}
