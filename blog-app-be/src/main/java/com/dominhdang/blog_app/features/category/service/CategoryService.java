package com.dominhdang.blog_app.features.category.service;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.category.dto.CategoryDetailDto;
import com.dominhdang.blog_app.features.category.dto.CategoryFormDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.models.ApiResponse;

public interface CategoryService {
    ApiResponse<CategoryDetailDto> saveCategory(CategoryFormDto category);

    ApiResponse<CategoryDetailDto> saveCategory(UUID id, CategoryFormDto category);

    ApiResponse<CategoryDetailDto> getDetailCategory(UUID id);

    ApiResponse<CategoryDetailDto> toggleCategoryShowOnMenu(UUID id);

    ApiResponse<List<CategoryItemDto>> getAllByName(String name, int currentPage, int pageSize);

    ApiResponse<?> deleteCategory(UUID id);

}
