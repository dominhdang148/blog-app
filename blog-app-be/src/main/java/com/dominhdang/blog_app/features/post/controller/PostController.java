package com.dominhdang.blog_app.features.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.service.PostService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/post")
@Tag(name = "Post Endpoints", description = "Endpoints used for managing posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostManageDetailDto>> postMethodName(@RequestBody PostFormDto post) {
        ApiResponse<PostManageDetailDto> response = this.postService.savePost(post);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<PostClientItemDto>> getPostClientSide(
            @RequestParam(name = "title", defaultValue = "", required = false) String title,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        return null;
    }

}
