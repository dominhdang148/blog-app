package com.dominhdang.blog_app.features.post.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.dominhdang.blog_app.features.post.dto.PostClientDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostManageItemDto;
import com.dominhdang.blog_app.models.ApiResponse;

public interface PostService {
    ApiResponse<PostManageDetailDto> savePost(PostFormDto post);

    ApiResponse<PostManageDetailDto> savePost(UUID id, PostFormDto post);

    ApiResponse<PostManageDetailDto> updateImage(UUID id, MultipartFile image);

    ApiResponse<PostManageDetailDto> togglePublishPost(UUID id);

    ApiResponse<PostManageDetailDto> getAdminPostDetail(UUID id);

    ApiResponse<PostClientDetailDto> getClientPostDetail(UUID id);

    ApiResponse<List<PostClientItemDto>> getClientPostList(String title, int currentPage, int pageSize);

    ApiResponse<List<PostManageItemDto>> getAdminPostList(String title, int currentPage, int pageSize);

    ApiResponse<List<PostClientItemDto>> getPostByAuthorId(UUID authorId, int currentPage, int pageSize);

    ApiResponse<List<PostClientItemDto>> getPostByCategorySlug(String urlSlug, int currentPage, int pageSize);

    ApiResponse<List<PostClientItemDto>> getPostByTagSlug(String urlSlug, int currentPage, int pageSize);

    ApiResponse<?> deletePost(UUID id);

}
