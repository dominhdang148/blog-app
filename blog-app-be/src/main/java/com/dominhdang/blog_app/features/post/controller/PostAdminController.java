package com.dominhdang.blog_app.features.post.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostManageItemDto;
import com.dominhdang.blog_app.features.post.service.PostService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/admin/post")
@Tag(name = "Post Endpoints", description = "Post's endpoints")
public class PostAdminController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostManageDetailDto>> createPost(@Valid @RequestBody PostFormDto post) {
        ApiResponse<PostManageDetailDto> response = this.postService.savePost(post);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(value = "{id}/image", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<PostManageDetailDto>> uploadImage(@PathVariable UUID id,
            @RequestParam("imageFile") MultipartFile imageFile) {
        ApiResponse<PostManageDetailDto> response = this.postService.updateImage(id, imageFile);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<PostManageItemDto>>> getPostClientSide(
            @RequestParam(name = "title", defaultValue = "", required = false) String title,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<PostManageItemDto>> response = this.postService.getAdminPostList(title, currentPage, pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deletePost(@PathVariable UUID id) {
        ApiResponse<?> response = this.postService.deletePost(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping("/{id}/toggle-published")
    public ResponseEntity<ApiResponse<PostManageDetailDto>> togglePublishPost(@PathVariable UUID id) {
        ApiResponse<PostManageDetailDto> response = this.postService.togglePublishPost(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
