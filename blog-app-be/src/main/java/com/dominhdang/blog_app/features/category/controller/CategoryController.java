package com.dominhdang.blog_app.features.category.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.category.dto.CategoryDetailDto;
import com.dominhdang.blog_app.features.category.dto.CategoryFormDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.category.service.CategoryService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
@Tag(name = "Category Endpoints", description = "Category's endpoints for public access")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryItemDto>>> getAllCategorySearch(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<CategoryItemDto>> response = this.categoryService.getAllByName(name, currentPage, pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<CategoryDetailDto>> getDetailCategory(
            @PathVariable UUID id) {
        ApiResponse<CategoryDetailDto> response = this.categoryService.getDetailCategory(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDetailDto>> addCategory(
            @Valid @RequestBody CategoryFormDto category) {
        ApiResponse<CategoryDetailDto> response = this.categoryService.saveCategory(category);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<CategoryDetailDto>> updateCategory(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryFormDto updatedCategory) {

        ApiResponse<CategoryDetailDto> response = this.categoryService.saveCategory(id, updatedCategory);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping(value = "/{id}/toggle-show-on-menu")
    public ResponseEntity<ApiResponse<CategoryDetailDto>> toggleShowOnMenu(
            @PathVariable("id") UUID id) {
        ApiResponse<CategoryDetailDto> response = this.categoryService.toggleCategoryShowOnMenu(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCategory(
            @PathVariable UUID id) {
        ApiResponse<?> response = this.categoryService.deleteCategory(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
