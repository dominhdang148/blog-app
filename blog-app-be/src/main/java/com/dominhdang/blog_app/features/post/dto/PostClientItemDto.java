package com.dominhdang.blog_app.features.post.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostClientItemDto {
    private String id;
    private String title;
    private String shortDescription;
    private String urlSlug;
    private String imageUrl;
    private int viewCount;
    private LocalDateTime postedDate;
    private AuthorItemDto author;
    private CategoryItemDto category;
    private Set<TagItemDto> tags;
}
