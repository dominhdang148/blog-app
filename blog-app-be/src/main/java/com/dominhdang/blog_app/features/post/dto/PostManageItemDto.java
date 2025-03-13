package com.dominhdang.blog_app.features.post.dto;

import java.util.UUID;

import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostManageItemDto {
    private UUID id;
    private String title;
    private String shortDescription;
    private AuthorItemDto author;
    private CategoryItemDto category;
    private boolean published;
}
