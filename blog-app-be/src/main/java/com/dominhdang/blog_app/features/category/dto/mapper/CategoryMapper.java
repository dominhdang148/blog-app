package com.dominhdang.blog_app.features.category.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dominhdang.blog_app.features.category.dto.CategoryDetailDto;
import com.dominhdang.blog_app.features.category.dto.CategoryFormDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.category.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "showOnMenu", ignore = true)
    Category toEntity(CategoryFormDto category);

    CategoryDetailDto toDetailDto(Category category);

    @Mapping(target = "postCount", expression = "java(category.getPosts().size())")
    CategoryItemDto toItemDto(Category category);

}
