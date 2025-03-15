package com.dominhdang.blog_app.features.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.post.dto.PostClientDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.service.PostService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/post")
@Tag(name = "Post Endpoints", description = "Post's endpoints")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<PostClientItemDto>>> getPostClientSide(
            @RequestParam(name = "title", defaultValue = "", required = false) String title,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<PostClientItemDto>> response = this.postService.getClientPostList(title, currentPage,
                pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostClientDetailDto>> getDetailClientSidePost(@PathVariable UUID id) {
        ApiResponse<PostClientDetailDto> response = this.postService.getClientPostDetail(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
