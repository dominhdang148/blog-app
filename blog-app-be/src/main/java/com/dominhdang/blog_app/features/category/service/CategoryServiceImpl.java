
package com.dominhdang.blog_app.features.category.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dominhdang.blog_app.features.category.dto.CategoryDetailDto;
import com.dominhdang.blog_app.features.category.dto.CategoryFormDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.category.dto.mapper.CategoryMapper;
import com.dominhdang.blog_app.features.category.entity.Category;
import com.dominhdang.blog_app.features.category.repository.CategoryRepository;
import com.dominhdang.blog_app.models.ApiResponse;
import com.dominhdang.blog_app.models.Pagination;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ApiResponse<CategoryDetailDto> saveCategory(CategoryFormDto category) {
        if (!this.categoryRepository.existsByNameIgnoreCaseOrUrlSlugIgnoreCase(category.getName(),
                category.getUrlSlug())) {
            Category newCategory = categoryMapper.toEntity(category);
            return ApiResponse.<CategoryDetailDto>builder()
                    .data(categoryMapper.toDetailDto(categoryRepository.save(newCategory)))
                    .message("Add category sucessfully")
                    .status(HttpStatus.CREATED)
                    .build();
        }
        return ApiResponse.<CategoryDetailDto>builder().status(HttpStatus.BAD_REQUEST)
                .message("Category has already existed").build();
    }

    @Override
    public ApiResponse<CategoryDetailDto> saveCategory(UUID id, CategoryFormDto category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isEmpty()) {
            return ApiResponse.<CategoryDetailDto>builder().status(HttpStatus.NOT_FOUND)
                    .message(String.format("Category with id: %s is not existed", id)).build();
        }
        Category oldCategory = existingCategory.get();
        boolean isDuplicated = !oldCategory.getName().equalsIgnoreCase(category.getName())
                || !oldCategory.getUrlSlug().equalsIgnoreCase(category.getUrlSlug());
        if (isDuplicated
                && this.categoryRepository.existsByNameIgnoreCaseOrUrlSlugIgnoreCaseAndIdNot(category.getName(),
                        category.getUrlSlug(), id)) {
            return ApiResponse.<CategoryDetailDto>builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Updated category might already exist").build();
        }
        Category updatedCategory = categoryMapper.toEntity(category);
        updatedCategory.setId(id);
        CategoryDetailDto result = categoryMapper.toDetailDto(categoryRepository.save(updatedCategory));

        return ApiResponse.<CategoryDetailDto>builder()
                .status(HttpStatus.OK)
                .message("Category updated successfully")
                .data(result)
                .build();
    }

    @Override
    public ApiResponse<CategoryDetailDto> getDetailCategory(UUID id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ApiResponse.<CategoryDetailDto>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message(String.format("Author with id: %s not found", id))
                    .build();
        }
        return ApiResponse.<CategoryDetailDto>builder()
                .status(HttpStatus.NOT_FOUND)
                .data(this.categoryMapper.toDetailDto(category))
                .message(String.format("Author with id: %s not found", id))
                .build();

    }

    @Override
    public ApiResponse<List<CategoryItemDto>> getAllByName(String name, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<CategoryItemDto> result = this.categoryRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(category -> this.categoryMapper.toItemDto(category));
        Pagination pagination = Pagination.builder().currentPage(currentPage).pageSize(pageSize)
                .totalPages(result.getTotalPages()).totalItems(result.getTotalElements()).build();
        return ApiResponse.<List<CategoryItemDto>>builder()
                .status(HttpStatus.OK)
                .data(result.toList())
                .message("Get Category List successfully")
                .pagination(pagination)
                .build();
    }

    @Override
    public ApiResponse<List<CategoryItemDto>> getAllShownOnMenu() {

        List<CategoryItemDto> result = this.categoryRepository.findByShowOnMenuTrue().stream()
                .map(category -> this.categoryMapper.toItemDto(category)).toList();

        return ApiResponse.<List<CategoryItemDto>>builder()
                .status(HttpStatus.OK)
                .data(result)
                .message("Get Category List successfully")
                .build();
    }

    @Override
    public ApiResponse<?> deleteCategory(UUID id) {

        Category category = this.categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ApiResponse.builder()
                    .message(String.format("Category with id: %s not found", id))

                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        this.categoryRepository.delete(category);
        return ApiResponse.builder()
                .message(String.format("Category with id: %s deleted successfully", id))
                .status(HttpStatus.NO_CONTENT)
                .build();

    }

    @Override
    public ApiResponse<CategoryDetailDto> toggleCategoryShowOnMenu(UUID id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ApiResponse.<CategoryDetailDto>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message(String.format("Categyry with id: %s not found", id))
                    .build();
        }
        category.setShowOnMenu(!category.getShowOnMenu());
        return ApiResponse.<CategoryDetailDto>builder()
                .status(HttpStatus.OK)
                .data(this.categoryMapper.toDetailDto(this.categoryRepository.save(category)))
                .message(String.format("Category with id: %s updated successfully", id))
                .build();
    }

}
