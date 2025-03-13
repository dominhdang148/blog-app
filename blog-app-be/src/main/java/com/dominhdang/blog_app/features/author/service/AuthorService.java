package com.dominhdang.blog_app.features.author.service;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.author.dto.AuthorDetailDto;
import com.dominhdang.blog_app.features.author.dto.AuthorFormDto;
import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.models.ApiResponse;

public interface AuthorService {
    ApiResponse<AuthorDetailDto> saveAuthor(AuthorFormDto author);

    ApiResponse<AuthorDetailDto> saveAuthor(UUID id, AuthorFormDto author);

    ApiResponse<AuthorDetailDto> updateAvatar(UUID id, String imageUrl);

    ApiResponse<List<AuthorItemDto>> getAllByName(String name, int currentPage, int pageSize);

    ApiResponse<AuthorDetailDto> getById(UUID id);

    ApiResponse<?> deleteById(UUID id);

}
