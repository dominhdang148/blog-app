package com.dominhdang.blog_app.features.tag.service;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.tag.dto.TagDetailDto;
import com.dominhdang.blog_app.features.tag.dto.TagFormDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;
import com.dominhdang.blog_app.models.ApiResponse;

public interface TagService {
    ApiResponse<TagDetailDto> saveTag(TagFormDto tag);

    ApiResponse<TagDetailDto> saveTag(UUID id, TagFormDto tag);

    ApiResponse<TagDetailDto> getById(UUID id);

    ApiResponse<List<TagItemDto>> getAllTagsContainingName(String name, int currentPage, int pageSize);

    ApiResponse<?> deleteTag(UUID id);

}
