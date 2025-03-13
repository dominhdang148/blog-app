package com.dominhdang.blog_app.features.post.service;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.post.dto.PostClientDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostManageItemDto;
import com.dominhdang.blog_app.models.ApiResponse;

public interface PostService {
    ApiResponse<PostManageDetailDto> savePost(PostFormDto post);

    ApiResponse<PostClientDetailDto> getClientPostDetail(UUID id);

    ApiResponse<PostManageDetailDto> getAdminPostDetail(UUID id);

    ApiResponse<List<PostClientItemDto>> getClientPostList(String name, int currentPage, int pageSize);

    ApiResponse<List<PostManageItemDto>> getAdminPostList(String name, int currentPage, int pageSize);
}
