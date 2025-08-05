package com.endava.backend.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Collections;
import com.endava.backend.dtos.AccountDTO;
import com.endava.backend.entities.Account;

@Component
public class AccountMapper {
    
    public Account dtoToEntity(AccountDTO dto) {
        if(dto == null) return null;

        return Account.builder().accountId(dto.getAccountId()).name(dto.getName())
        .accountType(dto.getAccountType()).balance(dto.getBalance())
        .createdAt(dto.getCreatedAt()).updatedAt(dto.getUpdatedAt())
        .build();
    }

    public AccountDTO entityToDto(Account entity) {
        if(entity == null) return null;

        return AccountDTO.builder().accountId(entity.getAccountId()).name(entity.getName())
        .accountType(entity.getAccountType()).balance(entity.getBalance())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt())
        .build();
    }

    public List<AccountDTO> entityListToDtoList(List<Account> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDto).toList();
    }
}
