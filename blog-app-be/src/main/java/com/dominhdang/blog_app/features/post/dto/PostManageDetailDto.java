package com.dominhdang.blog_app.features.post.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostManageDetailDto {
    private UUID id;
    private String title;
    private String shortDescription;
    private String description;
    private String meta;
    private String urlSlug;
    private String imageUrl;
    private boolean published;
    private LocalDateTime postedDate;
    private CategoryItemDto category;
    private AuthorItemDto author;
    private String tags;
}
