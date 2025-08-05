package com.endava.backend.mapper;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import com.endava.backend.dtos.CategoryDTO;
import com.endava.backend.entities.Category;


@Component
public class CategoryMapper {
    
    public Category dtoToEntity(CategoryDTO dto) {
        if(dto == null) return null;

        return Category.builder().categoryId(dto.getCategoryId()).user(dto.getUser())
        .categoryName(dto.getCategoryName()).categoryType(dto.getCategoryType())
        .createdAt(dto.getCreatedAt()).updatedAt(dto.getUpdatedAt()).build();
    } 

    public CategoryDTO entityToDto(Category entity) {
        if(entity == null) return null;

        return CategoryDTO.builder().categoryId(entity.getCategoryId()).user(entity.getUser())
        .categoryName(entity.getCategoryName()).categoryType(entity.getCategoryType())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }

   public List<CategoryDTO> entityListToDtoList(List<Category> entities) {
        if(entities == null) return Collections.emptyList();

        return entities.stream().map(this::entityToDto).toList();
    }
    
}
