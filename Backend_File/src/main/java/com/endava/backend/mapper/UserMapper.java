package com.endava.backend.mapper;

import org.springframework.stereotype.Component;
import com.endava.backend.dtos.UserDTO;
import com.endava.backend.entities.User;
import java.util.List;
import java.util.Collections;


@Component
public class UserMapper {
    
    public User dtoToEntity(UserDTO dto) {
		if (dto == null)
			return null;

		return User.builder().userId(dto.getUserId()).firstName(dto.getFirstName()).lastName(dto.getLastName())
				.email(dto.getEmail()).phoneNumber(dto.getPhoneNumber()).passwordHash(dto.getPasswordHash())
				.createdAt(dto.getCreatedAt())
				.build();

	}

    public UserDTO entityToDto(User entity) {
		if (entity == null)
			return null;

		return UserDTO.builder().userId(entity.getUserId()).firstName(entity.getFirstName())
				.lastName(entity.getLastName()).passwordHash(entity.getPasswordHash()).email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber()).createdAt(entity.getCreatedAt())
				.build();
	}

    public List<UserDTO> entityListToDtoList(List<User> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDto).toList();
    }
}
