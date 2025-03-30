package com.dominhdang.blog_app.features.category.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.category.dto.CategoryDetailDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.category.service.CategoryService;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.service.PostService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/category")
@Tag(name = "Category Endpoints", description = "Category's endpoints")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryItemDto>>> getAllShownOnMenu() {
        ApiResponse<List<CategoryItemDto>> response = this.categoryService.getAllShownOnMenu();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<CategoryDetailDto>> getDetailCategory(
            @PathVariable UUID id) {
        ApiResponse<CategoryDetailDto> response = this.categoryService.getDetailCategory(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{slug}/posts")
    public ResponseEntity<ApiResponse<List<PostClientItemDto>>> getPostByCategory(
            @PathVariable String slug,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<PostClientItemDto>> response = this.postService.getPostByCategorySlug(slug, currentPage,
                pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
